package com.example.yuchihan.doordashpro.Client;

import android.support.annotation.NonNull;

import com.example.yuchihan.doordashpro.model.Restaurant;

import java.util.List;

import io.reactivex.Observable;

/**
 * Restaurant searcher.
 */
public class RestaurantSearcher {

    @NonNull private static final String SF_LAT = "37.422740";
    @NonNull private static final String SF_LNG = "-122.139956";

    @NonNull private final ApiClient apiClient = new ApiClient();

    public RestaurantSearcher() { }

    public Observable<List<Restaurant>> restaurants() {
        return apiClient.doordashApi().getRestaurants(SF_LAT, SF_LNG);
    }
}
