package com.example.yuchihan.doordashpro.search;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.example.yuchihan.doordashpro.R;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.example.yuchihan.doordashpro.restaurants.RestaurantResultsAdapter;

import java.util.List;

public class SearchView extends CardView implements RestaurantResultsAdapter.Listener {

    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private RestaurantResultsAdapter restaurantResultViewAdapter;

    public SearchView(Context context) {
        this(context, null);
    }

    public SearchView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SearchView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
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
    public void onItemSelected(@NonNull Restaurant restaurant) { }

    /**
     * @param restaurants a list of {@link Restaurant}.
     */
    public void setViewModels(@NonNull List<Restaurant> restaurants) {
        restaurantResultViewAdapter.setViewModels(restaurants);
    }


}
