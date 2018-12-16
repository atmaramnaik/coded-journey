package com.atmaram.cj.core;

public interface Map {
    public void put(String key, Data data);
    public Data get(String key);
    public boolean contains(String key);
    public void loadAllChilds();
    public void unloadAllChilds();

}
