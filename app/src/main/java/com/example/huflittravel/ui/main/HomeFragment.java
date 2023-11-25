package com.example.huflittravel.ui.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.huflittravel.MainActivity;
import com.example.huflittravel.R;
import com.example.huflittravel.adapter.TourAdapter;
import com.example.huflittravel.databinding.FragmentHomeBinding;
import com.example.huflittravel.models.Tour;
import com.example.huflittravel.services.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    View v;
    TourAdapter tourAdapter;
    MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        v = binding.getRoot();

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel(R.drawable.dulich1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.dulich2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.dulich3, ScaleTypes.FIT));

        binding.imgSlider.setImageList(slideModels, ScaleTypes.CENTER_CROP);

        mainActivity = (MainActivity) getActivity();
        tourAdapter = mainActivity.getTourAdapter();
        LinearLayoutManager linearLayout = new LinearLayoutManager(mainActivity);

        binding.recyclerView.setAdapter(tourAdapter);
        binding.recyclerView.setLayoutManager(linearLayout);
        return v;
    }


}