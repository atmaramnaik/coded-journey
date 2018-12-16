package com.atmaram.cj.core;

import java.util.HashMap;

public class DataMap extends Data implements Map {

    public HashMap<String,Data> data;

    public DataMap(Context context) {
        this.context = context;
        this.data=new HashMap<>();
    }
    public DataMap(Context context,HashMap<String,Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public void put(String key,Data data) {
        this.data.put(key,data);
    }

    @Override
    public Data get(String key) {
        return this.data.get(key);
    }

    @Override
    public boolean contains(String key) {
        return this.data.containsKey(key);
    }

    @Override
    public void remove(String key) {
        if(data.containsKey(key)){
            data.remove(key);
        }
    }

    @Override
    public void loadAllChilds() {
        for (String key:
             data.keySet()) {
            context.load(key,data.get(key));
        }
    }

    @Override
    public void unloadAllChilds() {
        for (String key:
                data.keySet()) {
            context.unLoad(key,data.get(key));
        }
    }

}
