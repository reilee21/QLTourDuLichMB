package com.example.huflittravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.example.huflittravel.adapter.LichTrinhAdapter;
import com.example.huflittravel.databinding.ActivityLoginBinding;
import com.example.huflittravel.databinding.ActivityTourDetailBinding;
import com.example.huflittravel.models.LichTrinh;
import com.example.huflittravel.models.Tour;
import com.example.huflittravel.services.ApiClient;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TourDetailActivity extends AppCompatActivity {
    ActivityTourDetailBinding binding;
    Tour tour;
    String image;
    LichTrinhAdapter lichTrinhAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTourDetailBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tour = (Tour) bundle.getSerializable("tour");
            image = bundle.getString("img");
            if (tour != null) {
                Log.i("abc", tour.toString());
                setupUI();
                getLichTrinh();
            }
        }
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        binding.recyclerViewLichTrinh.setAdapter(lichTrinhAdapter);
        binding.recyclerViewLichTrinh.setLayoutManager(linearLayout);

        binding.btnBk.setOnClickListener(v -> booking());
    }

    private void booking() {
        Intent intent = new Intent(this, BookingActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("tour", tour);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void setupUI() {
        Picasso.get().load(image).into(binding.imageViewTour);
        binding.textViewMaTourValue.setText(tour.getMaTour());
        binding.textViewNgayKhoiHanhValue.setText(tour.getNgayKhoiHanh());
        binding.textViewTenTourValue.setText(tour.getTenTour());
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        binding.tvGia.setText(currencyVN.format(tour.getGia()));
    }


    private void getLichTrinh() {
        lichTrinhAdapter = new LichTrinhAdapter();
        Call<List<LichTrinh>> call = ApiClient.getInstance().getMyApi().getAllLt();
        call.enqueue(new Callback<List<LichTrinh>>() {
            @Override
            public void onResponse(Call<List<LichTrinh>> call, Response<List<LichTrinh>> response) {
                if (response.isSuccessful()) {
                    List<LichTrinh> list = response.body();
                    for (LichTrinh lt : list) {
                        if (lt.getMaTour().equals(tour.getMaTour())) {
                            lichTrinhAdapter.addLT(lt);
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<LichTrinh>> call, Throwable t) {

            }
        });
    }
}