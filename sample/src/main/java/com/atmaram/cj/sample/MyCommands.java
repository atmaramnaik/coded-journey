package com.atmaram.cj.sample;

import com.atmaram.cj.core.*;
import com.atmaram.cj.core.http.HttpHelper;
import com.atmaram.cj.core.http.PostRequest;

public class MyCommands {
    @Command(name = "Load Data from file 1")
    public void load1(Context context){
        System.out.println(context.JourneyName);
        List<DataObject> data=(List<DataObject>) context.get("vars");
        data.forEach(dataObject -> {
            System.out.println(dataObject.data.toString());
        });

    }
    @Command(name = "Load Data from file 2")
    public void load2(Context context){
        System.out.println(context.JourneyName);
    }
}
