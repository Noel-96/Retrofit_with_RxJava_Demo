package com.noel_inc.retrofit_with_rxjava_demo.network.retrofitclient;

import com.noel_inc.retrofit_with_rxjava_demo.network.apimodel.gettopgamesmodel.Twitch;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface TwitchAPI {



    @GET("games/top?client_id=47jgf7ms4lo80w5tk5ab20xtf2knu9")
    Call<Twitch> getTopGames();


    @GET("games/top?client_id=47jgf7ms4lo80w5tk5ab20xtf2knu9")
    Observable<Twitch> getTopGamesObservable();
}
