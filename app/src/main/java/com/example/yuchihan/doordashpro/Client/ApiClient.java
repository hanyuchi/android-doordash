package com.example.yuchihan.doordashpro.Client;

import android.support.annotation.NonNull;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Api client.
 */
public class ApiClient {

    @NonNull private static final String DOORDASH_URL_ROOT = "https://api.doordash.com";

    @NonNull private DoordashApi doordashApi;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(DOORDASH_URL_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        doordashApi = retrofit.create(DoordashApi.class);
    }

    /**
     * @return {@link DoordashApi}.
     */
    public DoordashApi doordashApi() {
        return doordashApi;
    }
}
