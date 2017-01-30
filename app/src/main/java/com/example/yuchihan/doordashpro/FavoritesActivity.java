package com.example.yuchihan.doordashpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;

import com.example.yuchihan.doordashpro.Utils.SharePreferencesUtil;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.example.yuchihan.doordashpro.restaurants.RestaurantsController;

import java.util.List;

/**
 * Favorites activity.
 */
public class FavoritesActivity extends AppCompatActivity {

    private RestaurantsController restaurantResultsController;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorites);

        restaurantResultsController = new RestaurantsController(this);
        rootView = (ViewGroup) findViewById(R.id.favorites);
        restaurantResultsController.setRootView(rootView);

        List<Restaurant> restaurants = SharePreferencesUtil.getFavoriteRestaurants(this);
        restaurantResultsController.updateRestaurants(restaurants);
    }
}
