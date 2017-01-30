package com.example.yuchihan.doordashpro.restaurants;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.example.yuchihan.doordashpro.R;
import com.example.yuchihan.doordashpro.Utils.SharePreferencesUtil;
import com.example.yuchihan.doordashpro.model.Restaurant;

import java.util.List;

/**
 * Restaurants controller.
 */
public class RestaurantsController implements RestaurantResultsView.Listener {

    @NonNull private Activity activity;

    private RestaurantResultsView restaurantResultsView;
    private ViewGroup rootView;

    public RestaurantsController(@NonNull Activity activity) {
        this.activity = activity;
    }

    /**
     * Set the root view to use to add and remove views into.
     *
     * @param rootView The root view.
     */
    public void setRootView(@NonNull ViewGroup rootView) {
        this.rootView = rootView;
        initRestaurantsView();
    }

    /**
     * @param restaurants a list of {@link Restaurant}.
     */
    public void updateRestaurants(@NonNull List<Restaurant> restaurants) {
        restaurantResultsView.setViewModels(restaurants);
    }

    private void initRestaurantsView() {
        restaurantResultsView = (RestaurantResultsView) activity.getLayoutInflater().inflate(R.layout.restaurants, rootView, false);
        rootView.addView(restaurantResultsView);
        restaurantResultsView.setListener(this);
    }

    @Override
    public void onRestaurantSelected(@NonNull Restaurant restaurant) {
        SharePreferencesUtil.updateFavoriteRestaurants(activity, restaurant);
    }
}
