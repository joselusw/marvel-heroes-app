package com.jsw.marvelheroes.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HeroesAPI {
    /* -- VARS --*/
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://gateway.marvel.com/";

    /* -- FUNCTIONS --*/

    /**
     * Instance the retrofit object
     */
    public static Retrofit getInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
