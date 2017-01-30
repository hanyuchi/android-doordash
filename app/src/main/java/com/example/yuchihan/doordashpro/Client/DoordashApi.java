package com.example.yuchihan.doordashpro.Client;

import com.example.yuchihan.doordashpro.model.AuthToken;
import com.example.yuchihan.doordashpro.model.Restaurant;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Retrofit interface for making calls to endpoints.
 */
public interface DoordashApi {

    @FormUrlEncoded
    @POST("/v2/auth/token/")
    Observable<AuthToken> getToken(
            @Field("email") String email,
            @Field("password") String password);

    @GET("/v2/restaurant/")
    Observable<List<Restaurant>> getRestaurants(
            @Query("lat") String lat,
            @Query("lng") String lng);
}
