package com.noel_inc.retrofit_with_rxjava_demo.root;

import android.app.Application;

import com.noel_inc.retrofit_with_rxjava_demo.network.retrofitclient.ApiModule;

public class App  extends Application {

    private  ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();

    }

    public ApplicationComponent getComponent() {
        return component;
    }

}

