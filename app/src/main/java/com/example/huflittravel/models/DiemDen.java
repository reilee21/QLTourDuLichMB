package com.example.huflittravel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiemDen {

    @SerializedName("idDiemDen")
    @Expose
    private String idDiemDen;
    @SerializedName("tenDiemDen")
    @Expose
    private String tenDiemDen;
    @SerializedName("idDiaDiem")
    @Expose
    private Integer idDiaDiem;
    @SerializedName("idDiaDiemNavigation")
    @Expose
    private Object idDiaDiemNavigation;
    @SerializedName("lichTrinhs")
    @Expose
    private List<Object> lichTrinhs;

    public String getIdDiemDen() {
        return idDiemDen;
    }

    public void setIdDiemDen(String idDiemDen) {
        this.idDiemDen = idDiemDen;
    }

    public String getTenDiemDen() {
        return tenDiemDen;
    }

    public void setTenDiemDen(String tenDiemDen) {
        this.tenDiemDen = tenDiemDen;
    }

    public Integer getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(Integer idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public Object getIdDiaDiemNavigation() {
        return idDiaDiemNavigation;
    }

    public void setIdDiaDiemNavigation(Object idDiaDiemNavigation) {
        this.idDiaDiemNavigation = idDiaDiemNavigation;
    }

    public List<Object> getLichTrinhs() {
        return lichTrinhs;
    }

    public void setLichTrinhs(List<Object> lichTrinhs) {
        this.lichTrinhs = lichTrinhs;
    }

}
