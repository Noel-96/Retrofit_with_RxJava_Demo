package com.noel_inc.retrofit_with_rxjava_demo.root;

import com.noel_inc.retrofit_with_rxjava_demo.MainActivity;
import com.noel_inc.retrofit_with_rxjava_demo.network.retrofitclient.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class , ApiModule.class})
public interface ApplicationComponent {


    void inject(MainActivity target);
}

