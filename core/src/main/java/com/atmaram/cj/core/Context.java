package com.atmaram.cj.core;

import java.util.HashMap;
import java.util.Stack;

public class Context {
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
            this.data.put(name,stackHashMap.get(name).pop());
        }
    }
}
