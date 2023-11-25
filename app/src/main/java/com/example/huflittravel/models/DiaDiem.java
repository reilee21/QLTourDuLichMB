package com.example.huflittravel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DiaDiem {
    public DiaDiem(String tenDiaDiem, Boolean loai) {
        this.tenDiaDiem = tenDiaDiem;
        this.loai = loai;
    }

    @Override
    public String toString() {
        return "DiaDiem{" +
                "idDiaDiem=" + idDiaDiem +
                ", tenDiaDiem='" + tenDiaDiem + '\'' +
                ", loai=" + loai +
                ", diemDens=" + diemDens +
                '}';
    }

    @SerializedName("idDiaDiem")
    @Expose
    private Integer idDiaDiem;
    @SerializedName("tenDiaDiem")
    @Expose
    private String tenDiaDiem;
    @SerializedName("loai")
    @Expose
    private Boolean loai;
    @SerializedName("diemDens")
    @Expose
    private List<Object> diemDens;

    public Integer getIdDiaDiem() {
        return idDiaDiem;
    }

    public void setIdDiaDiem(Integer idDiaDiem) {
        this.idDiaDiem = idDiaDiem;
    }

    public String getTenDiaDiem() {
        return tenDiaDiem;
    }

    public void setTenDiaDiem(String tenDiaDiem) {
        this.tenDiaDiem = tenDiaDiem;
    }

    public Boolean getLoai() {
        return loai;
    }

    public void setLoai(Boolean loai) {
        this.loai = loai;
    }

    public List<Object> getDiemDens() {
        return diemDens;
    }

    public void setDiemDens(List<Object> diemDens) {
        this.diemDens = diemDens;
    }
}
