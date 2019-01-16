package com.noel_inc.retrofit_with_rxjava_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.noel_inc.retrofit_with_rxjava_demo.network.apimodel.gettopgamesmodel.Top;
import com.noel_inc.retrofit_with_rxjava_demo.network.apimodel.gettopgamesmodel.Twitch;
import com.noel_inc.retrofit_with_rxjava_demo.network.retrofitclient.TwitchAPI;
import com.noel_inc.retrofit_with_rxjava_demo.root.App;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.functions.Func1;
import io.reactivex.schedulers.Schedulers;

import static rx.Observable.from;

public class MainActivity extends AppCompatActivity {


    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((App) getApplication()).getComponent().inject(this);



        twitchAPI.getTopGames().enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                Log.e("hxgo",gameList.toString());
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {

            }
        });

        twitchAPI.getTopGamesObservable()
                .flatMap(new Func1<Twitch, Observable<Top>>(){
                    @Override
                    public  Observable<Top> call (Twitch twitch){
                        return  Observable.from(twitch.getTop());
                    }
                }).flatMap(new Func1<Top, Observable<String>>(){
                    @Override
                    public  Observable<String> call (Top top){
                        return  Observable.just(top.getGame().getName());

                    }
        }).subscribeOn(AndroidSchedulers.mainThread()).observeOn(Schedulers.io()).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        
        }









    }






