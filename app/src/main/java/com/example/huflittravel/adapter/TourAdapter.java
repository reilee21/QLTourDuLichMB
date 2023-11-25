package com.example.huflittravel.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huflittravel.R;
import com.example.huflittravel.TourDetailActivity;
import com.example.huflittravel.models.Tour;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.TourViewHolder> {

    private List<Tour> tourList;

    public List<Tour> getTourList() {
        return tourList;
    }

    String[] imgs2 = {"https://media.travel.com.vn/tour/tfd_230210112929_151958.jpg", "https://media.travel.com.vn/tour/tfd_230907012520_442157_TUA%20PIN%20DIEN%20GIO.jpg", "https://media.travel.com.vn/tour/tfd_230907012454_636828_SAMTEN%20HILL.jpg", "https://media.travel.com.vn/tour/tfd_230308105539_996330.jpg", "https://media.travel.com.vn/tour/tfd_230308105553_092144.jpg", "https://media.travel.com.vn/tour/tfd_230308105638_549743.jpg", "https://media.travel.com.vn/tour/tfd_220715113518_926537.jpg",
            "https://media.travel.com.vn/tour/tfd_220715113644_024395.jpg", "https://media.travel.com.vn/tour/tfd_230810100109_048448_DONG%20THIEN%20CUNG%20(1).jpg", "https://media.travel.com.vn/tour/tfd_230810100356_206645_HOANG%20THANH%20THANG%20LONG.jpg", "https://media.travel.com.vn/tour/tfd_230927030812_376615_GRAND%20WORLD%20(14).jpg", "https://media.travel.com.vn/tour/tfd_230927030717_740493_DJI_0785.jpg", "https://media.travel.com.vn/tour/tfd_230926045704_563027_TOUR%204-5%20DAO%20(4).jpg", "https://media.travel.com.vn/tour/tfd_221116104623_890700.jpg", "https://media.travel.com.vn/tour/tfd_220111040613_472003.jpg", "https://media.travel.com.vn/tour/tfd_220111041104_804761.jpg", "https://media.travel.com.vn/tour/tfd_220518040036_681991.png", "https://media.travel.com.vn/tour/tfd_220518040207_068497.jpg", "https://media.travel.com.vn/destination/dc_200914_HOI%20AN%20-%20CHUA%20CAU_1.jpg", "https://media.travel.com.vn/tour/tfd_231013052814_896209_Ho%20lak.jpg", "https://media.travel.com.vn/tour/tfd_231013052732_544245_Thac%20Dray%20Nur.jpg"};


    private Context context;

    public void addTour(Tour t) {
        tourList.add(t);
        notifyDataSetChanged();

    }

    public TourAdapter(Context context) {
        this.context = context;
        this.tourList = new ArrayList<>();

    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tour, parent, false);
        return new TourViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour tour = tourList.get(position);

        holder.bind(tour);
        holder.touritem.setOnClickListener(v -> detail(tour));
    }

    private void detail(Tour tour) {
        Intent intent = new Intent(this.context, TourDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("tour", tour);

        Random random = new Random();
        int randomIndex = random.nextInt(imgs2.length);
        String image = imgs2[randomIndex];
        bundle.putString("img", image);

        intent.putExtras(bundle);
        this.context.startActivity(intent);

    }

    @Override
    public int getItemCount() {
        return tourList.size();
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        private TextView tenTourTextView;
        private ImageView imageView;
        private TextView soLuongNguoiTextView;
        private TextView maTourTextView;
        private TextView giaTextView;
        LinearLayout touritem;
        String[] imgs = {"https://media.travel.com.vn/tour/tfd_230210112929_151958.jpg", "https://media.travel.com.vn/tour/tfd_230907012520_442157_TUA%20PIN%20DIEN%20GIO.jpg", "https://media.travel.com.vn/tour/tfd_230907012454_636828_SAMTEN%20HILL.jpg", "https://media.travel.com.vn/tour/tfd_230308105539_996330.jpg", "https://media.travel.com.vn/tour/tfd_230308105553_092144.jpg", "https://media.travel.com.vn/tour/tfd_230308105638_549743.jpg", "https://media.travel.com.vn/tour/tfd_220715113518_926537.jpg",
                "https://media.travel.com.vn/tour/tfd_220715113644_024395.jpg", "https://media.travel.com.vn/tour/tfd_230810100109_048448_DONG%20THIEN%20CUNG%20(1).jpg", "https://media.travel.com.vn/tour/tfd_230810100356_206645_HOANG%20THANH%20THANG%20LONG.jpg", "https://media.travel.com.vn/tour/tfd_230927030812_376615_GRAND%20WORLD%20(14).jpg", "https://media.travel.com.vn/tour/tfd_230927030717_740493_DJI_0785.jpg", "https://media.travel.com.vn/tour/tfd_230926045704_563027_TOUR%204-5%20DAO%20(4).jpg", "https://media.travel.com.vn/tour/tfd_221116104623_890700.jpg", "https://media.travel.com.vn/tour/tfd_220111040613_472003.jpg", "https://media.travel.com.vn/tour/tfd_220111041104_804761.jpg", "https://media.travel.com.vn/tour/tfd_220518040036_681991.png", "https://media.travel.com.vn/tour/tfd_220518040207_068497.jpg", "https://media.travel.com.vn/destination/dc_200914_HOI%20AN%20-%20CHUA%20CAU_1.jpg", "https://media.travel.com.vn/tour/tfd_231013052814_896209_Ho%20lak.jpg", "https://media.travel.com.vn/tour/tfd_231013052732_544245_Thac%20Dray%20Nur.jpg"};

        public TourViewHolder(@NonNull View itemView) {
            super(itemView);
            tenTourTextView = itemView.findViewById(R.id.tenTourTextView);
            imageView = itemView.findViewById(R.id.imageView);
            soLuongNguoiTextView = itemView.findViewById(R.id.soLuongNguoiTextView);
            maTourTextView = itemView.findViewById(R.id.maTourTextView);
            giaTextView = itemView.findViewById(R.id.giaTextView);
            touritem = itemView.findViewById(R.id.touritem);

        }

        public void bind(Tour tour) {
            tenTourTextView.setText(tour.getTenTour());
            Random random = new Random();
            int randomIndex = random.nextInt(imgs.length);
            String image = imgs[randomIndex];
            Picasso.get().load(image).into(imageView);

            soLuongNguoiTextView.setText(String.valueOf(tour.getSoLuongNguoi() - tour.getSoLuongNguoiDaDat()));
            maTourTextView.setText(tour.getMaTour());
            Locale localeVN = new Locale("vi", "VN");
            NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
            giaTextView.setText(currencyVN.format(tour.getGia()));
        }
    }

   
}

