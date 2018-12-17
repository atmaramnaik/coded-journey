package com.atmaram.cj.core.io;

public abstract class Requestor {
    Responder responder;

    public Requestor(Responder responder) {
        this.responder = responder;
    }
    protected abstract void sendRequest(String name);
    public <T> T request(String name,Class<T> tClass){
        sendRequest(name);
        return responder.waitFor(name,tClass);
    }
}
