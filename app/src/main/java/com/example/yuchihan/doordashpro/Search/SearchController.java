package com.example.yuchihan.doordashpro.search;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.example.yuchihan.doordashpro.R;
import com.example.yuchihan.doordashpro.model.Restaurant;

import java.util.List;

public class SearchController {

    @NonNull
    private Activity activity;

    private SearchView searchView;
    private ViewGroup rootView;

    public SearchController(@NonNull Activity activity) {
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
     * Update restaurant list.
     *
     * @param restaurants list of {@link Restaurant}.
     */
    public void updateRestaurants(@NonNull List<Restaurant> restaurants) {
        searchView.setViewModels(restaurants);
    }

    private void initRestaurantsView() {
        searchView = (SearchView) activity.getLayoutInflater()
                .inflate(R.layout.search_results, rootView, false);
        rootView.addView(searchView);
    }
}
