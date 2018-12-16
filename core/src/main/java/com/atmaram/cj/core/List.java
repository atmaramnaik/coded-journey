package com.atmaram.cj.core;

public interface List<T extends Data> {
    public void forEach(Iteration<T> iteration);
}
