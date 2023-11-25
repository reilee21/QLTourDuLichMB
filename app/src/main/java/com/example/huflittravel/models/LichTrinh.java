package com.example.huflittravel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LichTrinh {

    @SerializedName("ngay")
    @Expose
    private String ngay;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("idDiemDen")
    @Expose
    private String idDiemDen;
    @SerializedName("maTour")
    @Expose
    private String maTour;
    @SerializedName("idDiemDenNavigation")
    @Expose
    private Object idDiemDenNavigation;
    @SerializedName("maTourNavigation")
    @Expose
    private Object maTourNavigation;

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getIdDiemDen() {
        return idDiemDen;
    }

    public void setIdDiemDen(String idDiemDen) {
        this.idDiemDen = idDiemDen;
    }

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public Object getIdDiemDenNavigation() {
        return idDiemDenNavigation;
    }

    public void setIdDiemDenNavigation(Object idDiemDenNavigation) {
        this.idDiemDenNavigation = idDiemDenNavigation;
    }

    public Object getMaTourNavigation() {
        return maTourNavigation;
    }

    public void setMaTourNavigation(Object maTourNavigation) {
        this.maTourNavigation = maTourNavigation;
    }
}
