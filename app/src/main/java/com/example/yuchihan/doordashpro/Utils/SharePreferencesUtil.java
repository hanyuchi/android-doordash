package com.example.yuchihan.doordashpro.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.yuchihan.doordashpro.model.AuthToken;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SharedPreferences Util.
 */
public class SharePreferencesUtil {

    @NonNull private static final String AUTH_TOKEN_FILE_NAME = ".doordash_token";
    @NonNull private static final String FAVORITE_RESTAURANTS_FILE_NAME = ".doordash_favorite_restaurants";

    private SharePreferencesUtil() { }

    /**
     * Update Auth token.
     *
     * @param context {@link Context}.
     * @param token {@link AuthToken}.
     */
    public static void updateAuthToken(@NonNull Context context, @NonNull AuthToken token) {
        SharedPreferences.Editor editor = context.getSharedPreferences(AUTH_TOKEN_FILE_NAME,
                Context.MODE_PRIVATE).edit();
        editor.putString("token", token.getToken());
        editor.apply();
    }

    /**
     * Get Auth token.
     *
     * @param context {@link Context}.
     * @return real token if it's not null.
     */
    @Nullable
    public static String getAuthToken(@NonNull Context context) {
        SharedPreferences prefs = context.getSharedPreferences(AUTH_TOKEN_FILE_NAME, Context.MODE_PRIVATE);
        return prefs.getString("token", null);
    }

    /**
     * Update favorite restaurant.
     *
     * @param context {@link Context}.
     * @param restaurant {@link Restaurant}.
     */
    public static void updateFavoriteRestaurants(
            @NonNull Context context,
            @NonNull Restaurant restaurant) {
        SharedPreferences.Editor editor = context.getSharedPreferences(FAVORITE_RESTAURANTS_FILE_NAME,
                Context.MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(restaurant);
        editor.putString(restaurant.getId(), json);
        editor.apply();

        // notification of adding to favorite list
        Toast.makeText(context, "Successfully add this to your favorite restaurant list!", Toast.LENGTH_LONG).show();
    }

    /**
     * Get all saved favorite restaurants.
     *
     * @param context {@link Context}.
     * @return the list of favorite {@link Restaurant}.
     */
    public static List<Restaurant> getFavoriteRestaurants(@NonNull Context context) {
        SharedPreferences prefs = context.getSharedPreferences(FAVORITE_RESTAURANTS_FILE_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();

        Map<String, ?> keys = prefs.getAll();
        List<Restaurant> favorites = new ArrayList<>();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            String json = prefs.getString(entry.getKey(), "");
            Restaurant restaurant = gson.fromJson(json, Restaurant.class);
            favorites.add(restaurant);
        }

        return favorites;
    }
}
