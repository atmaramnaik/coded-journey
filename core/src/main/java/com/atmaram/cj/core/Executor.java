package com.atmaram.cj.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Executor {
    public static void runProgram(CommandRegistry registry){
        int counter=0;
        for (var entry:
             registry.entries) {
            System.out.println(counter + 1 + ")" + entry.name);
            counter++;
        }
        System.out.println("Select:");
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        int index=0;
        try {
            index=Integer.parseInt(reader.readLine())-1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(registry.entries.size()>index){
            CommandRegistryEntry entry=registry.entries.get(index);
            System.out.println("Executing command: "+entry.name);
            try {
                Class<?> clazz=Class.forName(entry.enclosingClass);
                Constructor<?> ctr=clazz.getConstructor();
                Object obj=ctr.newInstance();
                Context context=new Context();
                context.JourneyName=entry.name;
                DataList<DataObject> list =new DataList<DataObject>(context,Arrays.asList(new DataObject(context,"Hello"),new DataObject(context,"World")));
                context.set("vars", list);
                clazz.getMethod(entry.methodName,Context.class).invoke(obj,context);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
