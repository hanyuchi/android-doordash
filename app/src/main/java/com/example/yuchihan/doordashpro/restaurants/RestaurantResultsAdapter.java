package com.example.yuchihan.doordashpro.restaurants;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yuchihan.doordashpro.R;
import com.example.yuchihan.doordashpro.model.Restaurant;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Restaurants view adapter.
 */
public class RestaurantResultsAdapter extends RecyclerView.Adapter<RestaurantResultsAdapter.ViewHolder> {

    @NonNull private final Listener listener;
    @NonNull private final Context context;

    private List<Restaurant> restaurants = new ArrayList<>();

    public RestaurantResultsAdapter(@NonNull Context context, @NonNull Listener listener) {
        this.context = context;
        this.listener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @NonNull private ImageView imageView;
        @NonNull private TextView textView;

        public ViewHolder(@NonNull View view) {
            super(view);

            this.imageView = (ImageView) view.findViewById(R.id.image);
            this.textView = (TextView) view.findViewById(R.id.title);
        }
    }

    @Override
    public RestaurantResultsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View View = LayoutInflater.from(parent.getContext()).inflate(R.layout.restaurant, parent, false);
        return new ViewHolder(View);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int position) {
        final Restaurant restaurant = restaurants.get(position);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemSelected(restaurant);
            }
        });

        if (!TextUtils.isEmpty(restaurant.getCoverImageUrl())) {
            Picasso.with(context).load(restaurant.getCoverImageUrl())
                    .error(R.drawable.icon)
                    .placeholder(R.drawable.icon)
                    .into(viewHolder.imageView);
        }

        viewHolder.textView.setText(restaurant.getName());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    /**
     * @param restaurants a list of {@link Restaurant}.
     */
    public void setViewModels(@NonNull List<Restaurant> restaurants) {
        int size = restaurants.size() > 20 ? 20 : restaurants.size();
        this.restaurants = new ArrayList<>(restaurants.subList(0, size));
        notifyDataSetChanged();
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
        void onItemSelected(@NonNull Restaurant restaurant);
    }
}
