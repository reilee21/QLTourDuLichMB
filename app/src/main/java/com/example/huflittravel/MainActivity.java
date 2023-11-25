package com.example.huflittravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.example.huflittravel.adapter.ScreenSlidePageAdapter;
import com.example.huflittravel.adapter.TourAdapter;
import com.example.huflittravel.databinding.ActivityLoginBinding;
import com.example.huflittravel.databinding.ActivityMainBinding;
import com.example.huflittravel.models.Tour;
import com.example.huflittravel.services.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    public TourAdapter getTourAdapter() {
        return tourAdapter;
    }

    TourAdapter tourAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        setupFragment();
        tourAdapter = new TourAdapter(this);
        callApi();

    }

    private void setupFragment() {
        ScreenSlidePageAdapter fragAdapter = new ScreenSlidePageAdapter(this);
        binding.fragVPmain.setAdapter(fragAdapter);
    }

    private void callApi() {
        Call<List<Tour>> call = ApiClient.getInstance().getMyApi().getAllTour();

        call.enqueue(new Callback<List<Tour>>() {
            @Override
            public void onResponse(Call<List<Tour>> call, Response<List<Tour>> response) {
                if (response.isSuccessful()) {
                    List<Tour> tourList = response.body();
                    int numberOfToursToAdd = Math.min(tourList.size(), 5);
                    for (int i = 0; i < numberOfToursToAdd; i++) {
                        tourAdapter.addTour(tourList.get(i));
                    }
                } else {
                    Log.i("abc", "KO");

                }
            }

            @Override
            public void onFailure(Call<List<Tour>> call, Throwable t) {
                Log.i("abc", "failed");
            }
        });
    }
}