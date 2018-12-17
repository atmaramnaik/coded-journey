package com.atmaram.cj.core.io;

public class StringToObject {
    public static <T> T convert(String data,Class<T> tClass){
        if(tClass.equals(Integer.class)){
            return (T)new Integer(Integer.parseInt(data));
        }
        return null;
    }
}
