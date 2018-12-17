package com.atmaram.cj.core.io.console;

import com.atmaram.cj.core.io.Responder;
import com.atmaram.cj.core.io.StringToObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleResponder implements Responder {
    BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));

    @Override
    public <T> T waitFor(String name, Class<T> tClass) {
        try {
            String data=reader.readLine();
            return StringToObject.convert(data,tClass);
        } catch (IOException ex){
            return null;
        }

    }
}
