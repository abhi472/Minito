package com.abhishek.minito.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.abhishek.minito.R;
import com.abhishek.minito.databinding.HeaderBinding;
import com.abhishek.minito.databinding.RestaurantListItemBinding;
import com.abhishek.minito.model.RestaurantInner;
import com.abhishek.minito.repository.DatabaseRepository;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

public class RestaurantListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final DatabaseRepository repository;
    private  boolean flag = true;
    private List<Object> restaurants;




    @Inject
    public RestaurantListAdapter(DatabaseRepository databaseRepository, boolean flag) {
        this.repository = databaseRepository;
        this.flag = flag;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        switch (i) {
            case 0 :
                RestaurantListItemBinding employeeListItemBinding =
                        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                                R.layout.restaurant_list_item, viewGroup, false);
                return new ViewHolder(employeeListItemBinding);
            case 1 :
                HeaderBinding headerBinding =
                        DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.header, viewGroup, false);
                return new HeaderViewHolder(headerBinding);

        }
        RestaurantListItemBinding employeeListItemBinding =
                DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                        R.layout.restaurant_list_item, viewGroup, false);
        return new ViewHolder(employeeListItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        switch (viewHolder.getItemViewType()) {
            case 0:   RestaurantInner restaurantInner = (RestaurantInner) restaurants.get(i);
                ((ViewHolder) viewHolder).restaurantListItemBinding.setRestaurant(restaurantInner);
                ((ViewHolder) viewHolder).restaurantListItemBinding
                    .setViewModel(new RestaurantListViewModel(repository));
                ((ViewHolder) viewHolder).restaurantListItemBinding
                        .setVisibility(flag);

                break;
            case 1:
                String header = (String) restaurants.get(i);
                ((HeaderViewHolder) viewHolder).headerBinding.setHeader(header);
                break;

        }

    }

    @Override
    public int getItemViewType(int position) {
        return restaurants.get(position) instanceof String ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        if (restaurants != null) {
            return restaurants.size();
        } else {
            return 0;
        }
    }

    public void setRestaurants(List<Object> restaurants) {
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {

        private HeaderBinding headerBinding;

        public HeaderViewHolder(@NonNull HeaderBinding headerBinding) {
            super(headerBinding.getRoot());

            this.headerBinding = headerBinding;
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private RestaurantListItemBinding restaurantListItemBinding;

        public ViewHolder(@NonNull RestaurantListItemBinding restaurantListItemBinding) {
            super(restaurantListItemBinding.getRoot());

            this.restaurantListItemBinding = restaurantListItemBinding;
        }
    }


}

