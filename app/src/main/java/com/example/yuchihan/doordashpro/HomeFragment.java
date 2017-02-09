package com.example.yuchihan.doordashpro;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yuchihan.doordashpro.Client.RestaurantSearcher;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.example.yuchihan.doordashpro.restaurants.RestaurantsController;
import com.google.gson.Gson;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Home Fragment.
 */
public class HomeFragment extends Fragment implements RestaurantsController.Listener {

    @NonNull private static final String RESTAURANT = "restaurant";
    @NonNull private static final Gson gson = new Gson();

    private RestaurantsController restaurantsController;
    private RestaurantSearcher restaurantSearcher = new RestaurantSearcher();

    public HomeFragment() { }

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        restaurantsController = new RestaurantsController(getActivity());
        restaurantsController.setListener(this);

        restaurantSearcher.restaurants()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<List<Restaurant>>() {
                    @Override
                    public void onNext(List<Restaurant> restaurants) {
                        restaurantsController.updateRestaurants(restaurants);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoadingError();
                    }

                    @Override
                    public void onComplete() { }
                });
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);
        restaurantsController.setRootView(rootView);
        return rootView;
    }

    @Override
    public void onRestaurantSelected(@NonNull Restaurant restaurant) {
        showRestaurantDetail(restaurant);
    }

    private void showLoadingError() {
        Toast.makeText(getContext(), "Error on loading restaurant list!", Toast.LENGTH_LONG).show();
    }

    private void showRestaurantDetail(@NonNull Restaurant restaurant) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra(RESTAURANT, gson.toJson(restaurant));
        startActivity(intent);
    }
}
