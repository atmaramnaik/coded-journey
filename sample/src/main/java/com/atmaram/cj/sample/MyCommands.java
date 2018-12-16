package com.atmaram.cj.sample;

import com.atmaram.cj.core.Command;
import com.atmaram.cj.core.Context;
import com.atmaram.cj.core.DataObject;
import com.atmaram.cj.core.List;

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
