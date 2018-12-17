package com.atmaram.cj.core.io;

public interface Responder {
    public <T> T waitFor(String name,Class<T> tClass);
}
