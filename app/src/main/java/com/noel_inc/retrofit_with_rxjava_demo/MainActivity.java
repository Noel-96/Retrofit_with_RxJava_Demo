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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    @Inject
    TwitchAPI twitchAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ((App) getApplication()).getComponent().inject(this);


        Call<Twitch> call = twitchAPI.getTopGames();

        call.enqueue(new Callback<Twitch>() {
            @Override
            public void onResponse(Call<Twitch> call, Response<Twitch> response) {
                List<Top> gameList = response.body().getTop();

                Log.e("hxgo",gameList.toString());
            }

            @Override
            public void onFailure(Call<Twitch> call, Throwable t) {

            }
        });
    }
}
