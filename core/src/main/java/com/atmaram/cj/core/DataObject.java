package com.atmaram.cj.core;

public class DataObject extends Data{
    public Context context;
    public Object data;

    public DataObject(Context context) {
        this.context = context;
    }

    public DataObject(Context context, Object data) {
        this.context = context;
        this.data = data;
    }
}
