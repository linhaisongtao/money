package com.example.daisongsong.moneytree;

import android.app.Application;

/**
 * Created by daisongsong on 2015/11/11.
 */
public class App extends Application{
    private static App sApp;

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
    }


    public static final App getInstance(){
        return sApp;
    }
}
