package com.example.huflittravel.services;

import com.example.huflittravel.models.Account;
import com.example.huflittravel.models.DiaDiem;
import com.example.huflittravel.models.KhachHang;
import com.example.huflittravel.models.LichTrinh;
import com.example.huflittravel.models.Tour;
import com.example.huflittravel.resmodels.AccountRes;
import com.example.huflittravel.resmodels.KhachHangRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    String BASE_URL = "https://huflittravel.somee.com";


    @GET("/api/KhachHangs")
    Call<List<KhachHangRes>> getAllKH();

    @GET("/api/LichTrinhs")
    Call<List<LichTrinh>> getAllLt();

    @GET("/api/Tours")
    Call<List<Tour>> getAllTour();

    @GET("/api/Tours/SearchTour")
    Call<List<Tour>> getTourbySearch();

    @GET("/api/Tours/{tourId}")
    Call<Tour> getTourById(@Path("tourId") String tourId);


    @POST("/api/TaiKhoans")
    Call<AccountRes> registerAccount(@Body AccountRes account);

    @POST("/api/diadiems")
    Call<DiaDiem> ThemDiaDiem(@Body DiaDiem diaDiem);

    @POST("/api/khachhangs")
    Call<KhachHangRes> ThemKhachHang(@Body KhachHangRes khachhang);

}
