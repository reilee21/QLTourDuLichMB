package com.example.huflittravel.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.huflittravel.R;
import com.example.huflittravel.models.LichTrinh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LichTrinhAdapter extends RecyclerView.Adapter<LichTrinhAdapter.LichTrinhViewHolder> {

    private List<LichTrinh> lichTrinhList;

    public void addLT(LichTrinh l) {
        this.lichTrinhList.add(l);
        notifyDataSetChanged();

    }

    public LichTrinhAdapter() {
        this.lichTrinhList = new ArrayList<>();
    }

    @NonNull
    @Override
    public LichTrinhViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lichtrinhitem, parent, false);
        return new LichTrinhViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LichTrinhViewHolder holder, int position) {
        LichTrinh lichTrinh = lichTrinhList.get(position);
        holder.bind(lichTrinh);
    }

    @Override
    public int getItemCount() {
        return lichTrinhList.size();
    }

    public static class LichTrinhViewHolder extends RecyclerView.ViewHolder {
        private TextView ngayTextView;
        private TextView moTaTextView;

        public LichTrinhViewHolder(@NonNull View itemView) {
            super(itemView);
            ngayTextView = itemView.findViewById(R.id.textViewNgayValue);
            moTaTextView = itemView.findViewById(R.id.textViewMoTaValue);
        }

        public void bind(LichTrinh lichTrinh) {
            ngayTextView.setText(formatNgay(lichTrinh.getNgay()));
            moTaTextView.setText(lichTrinh.getMoTa());
        }

        private String formatNgay(String ngay) {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault());
            SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            try {
                Date date = inputFormat.parse(ngay);
                return outputFormat.format(date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return ngay;
        }
    }
}
