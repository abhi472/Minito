package com.abhishek.minito.ui.favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.abhishek.minito.R;
import com.abhishek.minito.data.BaseCommand;
import com.abhishek.minito.databinding.ActivityFavoriteBinding;
import com.abhishek.minito.databinding.ActivityMainBinding;
import com.abhishek.minito.di.ViewModelFactory;
import com.abhishek.minito.ui.BaseActivity;
import com.abhishek.minito.ui.RestaurantListAdapter;
import com.abhishek.minito.ui.search.SearchViewModel;

import javax.inject.Inject;

public class FavoriteActivity extends BaseActivity {
    private FavoriteActivityViewModel viewModel;
    private ActivityFavoriteBinding binding;

    @Inject
    ViewModelFactory factory;

    @Inject
    RestaurantListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_favorite);
        viewModel = ViewModelProviders.of(this, factory).get(FavoriteActivityViewModel.class);
        if (binding != null) {
            binding.setViewModel(viewModel);
            viewModel.fetchDbData();



            binding.favList.setLayoutManager(new LinearLayoutManager(this));
            binding.favList.setHasFixedSize(true);

            binding.favList.setAdapter(adapter);

            viewModel.liveEvent.observe(this, baseCommand -> {
                if(baseCommand instanceof  BaseCommand.Success) {
                    adapter.setRestaurants(((BaseCommand.Success)baseCommand).getList());

                } else {
                    Log.d("problem", "gai9");
                }
            });

        }

    }
}
