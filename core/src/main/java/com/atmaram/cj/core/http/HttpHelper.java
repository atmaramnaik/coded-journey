package com.atmaram.cj.core.http;

import com.atmaram.cj.core.Context;
import com.atmaram.cj.core.DataMap;
import com.atmaram.cj.core.DataObject;

public class HttpHelper {
    public static DataMap post(PostRequest request, Context context){
        context.get("place",Integer.class);
        DataMap extractedData=new DataMap(context);
        extractedData.put("name",new DataObject(context,"Hello"));
        return extractedData;
    }
}
