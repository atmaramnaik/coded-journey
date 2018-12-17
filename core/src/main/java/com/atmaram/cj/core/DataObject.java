package com.atmaram.cj.core;

public class DataObject<T> extends Data{
    public Context context;
    public T data;

    public DataObject(Context context) {
        this.context = context;
    }

    public DataObject(Context context, T data) {
        this.context = context;
        this.data = data;
    }
}
