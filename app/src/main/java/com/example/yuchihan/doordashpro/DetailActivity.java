package com.example.yuchihan.doordashpro;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuchihan.doordashpro.model.Restaurant;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @NonNull private static final String RESTAURANT = "restaurant";
    @NonNull private static final Gson gson = new Gson();

    @NonNull private TextView description;
    @NonNull private ImageView imageView;
    @NonNull private TextView textView;
    @NonNull private Restaurant restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        imageView = (ImageView) findViewById(R.id.image);
        textView = (TextView) findViewById(R.id.title);
        description = (TextView) findViewById(R.id.description);
        restaurant = gson.fromJson(getIntent().getStringExtra(RESTAURANT), Restaurant.class);

        textView.setText(restaurant.getName());
        description.setText(restaurant.getId());

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(restaurant.getName());
        }

        Picasso.with(this).load(restaurant.getCoverImageUrl())
                .error(R.drawable.icon)
                .placeholder(R.drawable.icon)
                .into(imageView);
    }
}
