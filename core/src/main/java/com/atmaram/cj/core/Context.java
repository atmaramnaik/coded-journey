package com.atmaram.cj.core;

import com.atmaram.cj.core.io.Requestor;
import com.atmaram.cj.core.io.console.ConsoleRequestor;
import com.atmaram.cj.core.io.console.ConsoleResponder;

import java.util.HashMap;
import java.util.Stack;

public class Context {
    public Requestor requestor;
    public String JourneyName;
    HashMap<String,Stack<Data>> stackHashMap=new HashMap<>();
    private DataMap data=new DataMap(this);
    public void set(String name,Object value){
        data.put(name,new DataObject(this,value));
    }
    public void set(String name,Data value){
        data.put(name,value);
    }
    public Data get(String name){
        return data.get(name);
    }
    public <T> Data get(String name,Class<T> tClass){
        if(data.contains(name)){
            return data.get(name);
        } else {
            return requestor.request(name,tClass);
        }
    }
    public void load(String name,Data data){
        if(this.data.contains(name)){
            if(stackHashMap.containsKey(name)){
                stackHashMap.get(name).push(this.data.get(name));
            } else {
                Stack<Data> dataStack=new Stack<>();
                dataStack.push(this.data.get(name));
                stackHashMap.put(name,dataStack);
            }
            this.data.put(name,data);
        }
    }
    public void unLoad(String name,Data data){
        if(this.data.contains(name) && this.data.get(name)==data && stackHashMap.containsKey(name)){
            Stack<Data> dataStack=stackHashMap.get(name);
            if(dataStack.empty())
                this.data.remove(name);
            else {
                this.data.put(name,dataStack.pop());
            }
        }
    }
}
