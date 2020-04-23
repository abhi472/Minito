package com.abhishek.minito.ui.search;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.abhishek.minito.R;
import com.abhishek.minito.data.BaseCommand;
import com.abhishek.minito.databinding.ActivityMainBinding;
import com.abhishek.minito.di.ViewModelFactory;
import com.abhishek.minito.generated.callback.OnClickListener;
import com.abhishek.minito.ui.BaseActivity;
import com.abhishek.minito.ui.RestaurantListAdapter;
import com.abhishek.minito.ui.favorite.FavoriteActivity;

import javax.inject.Inject;

public class SearchActivity extends BaseActivity {

    private SearchViewModel viewModel;
    private ActivityMainBinding binding;

    @Inject
    ViewModelFactory factory;

    @Inject
    RestaurantListAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        viewModel = ViewModelProviders.of(this, factory).get(SearchViewModel.class);
        if (binding != null) {
            binding.setViewModel(viewModel);
            viewModel.fetchCuisines();


            binding.fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(SearchActivity.this,
                            FavoriteActivity.class);
                    startActivity(intent);
                }
            });

            binding.list.setLayoutManager(new LinearLayoutManager(this));
            binding.list.setHasFixedSize(true);

            binding.list.setAdapter(adapter);

            viewModel.liveEvent.observe(this, baseCommand -> {
                if(baseCommand instanceof  BaseCommand.Success) {
                    adapter.setRestaurants(((BaseCommand.Success)baseCommand).getList());

                } else {
                    Log.d("problem", "gai9");
                }
            });

        }
    }

    private void getAllEmployee() {

    }
}
