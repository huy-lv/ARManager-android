package com.example.huylv.armanager.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by huylv on 23-Feb-16.
 */
public class ServiceBuilder {
    private static final String BASE_URL = "http://vntech.me:8000/";

    private static Retrofit sInstance;
    private static MarkerService sService;

    private static Retrofit getRetrofit() {
        if (sInstance == null) {
            sInstance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return sInstance;
    }

    public static MarkerService getService() {
        if (sService == null) {
            sService = getRetrofit().create(MarkerService.class);
        }
        return sService;
    }
}
