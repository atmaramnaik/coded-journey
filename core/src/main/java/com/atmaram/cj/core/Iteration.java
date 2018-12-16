package com.atmaram.cj.core;
@FunctionalInterface
public interface Iteration<T extends Data> {
    public void doThis(T data);
}
