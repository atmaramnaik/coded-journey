package com.atmaram.cj.core.io.console;

import com.atmaram.cj.core.io.Requestor;
import com.atmaram.cj.core.io.Responder;

public class ConsoleRequestor extends Requestor {
    public ConsoleRequestor(Responder responder) {
        super(responder);
    }

    @Override
    public void sendRequest(String name) {
        System.out.println("Enter "+name);
    }
}
