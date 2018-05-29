package com.example.mhamada.session14;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by M.Hamada on 01/05/2018.
 */

public class Singleton {
    private static Context context;
    private static Singleton singleton;
    private RequestQueue requestQueue;
    Singleton(Context context){
        this.context=context;
        requestQueue=getRequestQueue();
    }
    public RequestQueue getRequestQueue(){
        if(requestQueue==null){
            requestQueue= Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }
    public  static synchronized Singleton getInstance(Context context){
        if(singleton==null){
            singleton=new Singleton(context);
        }
        return singleton;
    }
    public<T> void addtoRequestque(Request<T> request){
        requestQueue.add(request);
    }

}
