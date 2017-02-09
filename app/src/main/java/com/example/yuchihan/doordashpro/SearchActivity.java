package com.example.yuchihan.doordashpro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.yuchihan.doordashpro.Utils.SharePreferencesUtil;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.example.yuchihan.doordashpro.search.SearchController;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    private EditText searchBar;
    private SearchController searchController;
    private ViewGroup rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);

        searchController = new SearchController(this);
        rootView = (ViewGroup) findViewById(R.id.search);
        searchBar = (EditText) findViewById(R.id.search_bar);
        searchController.setRootView(rootView);

        if (searchBar != null) {
            searchBar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                @Override
                public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                    attemptSearch();
                    return false;
                }
            });
        }
    }

    private void attemptSearch() {
        List<Restaurant> restaurants = SharePreferencesUtil.getFavoriteRestaurants(this);
        String searchString = searchBar.getText().toString();

        List<Restaurant> list = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            String name = restaurant.getName();
            if (name != null && name.contains(searchString)) {
                list.add(restaurant);
            }
        }

        searchController.updateRestaurants(list);
    }
}
