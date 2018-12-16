package com.atmaram.cj.core;

public class CommandRegistryEntry {
    String name;
    String enclosingClass;
    String methodName;

    public CommandRegistryEntry(String name, String enclosingClass, String methodName) {
        this.name = name;
        this.enclosingClass = enclosingClass;
        this.methodName = methodName;
    }
}
