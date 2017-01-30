package com.example.yuchihan.doordashpro.restaurants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.yuchihan.doordashpro.R;
import com.example.yuchihan.doordashpro.model.Restaurant;

import java.util.List;

/**
 * Restaurants view.
 */
public class RestaurantResultsView extends CardView implements RestaurantResultsAdapter.Listener {

    private Listener listener;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RestaurantResultsAdapter restaurantResultViewAdapter;

    public RestaurantResultsView(Context context) {
        this(context, null);
    }

    public RestaurantResultsView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RestaurantResultsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * @param listener {@link Listener}.
     */
    void setListener(@NonNull Listener listener) {
        this.listener = listener;
    }

    @Override
    public void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = (RecyclerView) findViewById(R.id.list);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        restaurantResultViewAdapter = new RestaurantResultsAdapter(getContext(), this);
        recyclerView.setAdapter(restaurantResultViewAdapter);
    }

    @Override
    public void onItemSelected(@NonNull Restaurant restaurant) {
        listener.onRestaurantSelected(restaurant);
    }

    /**
     * @param restaurants a list of {@link Restaurant}.
     */
    public void setViewModels(@NonNull List<Restaurant> restaurants) {
        restaurantResultViewAdapter.setViewModels(restaurants);
    }

    /**
     * Callback listener.
     */
    public interface Listener {

        /**
         * On item selected.
         *
         * @param restaurant restaurant view model.
         */
        void onRestaurantSelected(@NonNull Restaurant restaurant);
    }
}
