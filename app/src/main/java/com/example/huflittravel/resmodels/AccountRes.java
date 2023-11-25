package com.example.huflittravel.resmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountRes {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("idTaiKhoan")
    @Expose
    private String idTaiKhoan;
    @SerializedName("maKh")
    @Expose
    private String maKh;
    @SerializedName("maKhNavigation")
    @Expose
    private Object maKhNavigation;

    @Override
    public String toString() {
        return "AccountRes{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", idTaiKhoan='" + idTaiKhoan + '\'' +
                ", maKh='" + maKh + '\'' +
                ", maKhNavigation=" + maKhNavigation +
                '}';
    }

    public AccountRes(String username, String password, String idTaiKhoan, String maKh, Object maKhNavigation) {
        this.username = username;
        this.password = password;
        this.idTaiKhoan = idTaiKhoan;
        this.maKh = maKh;
        this.maKhNavigation = maKhNavigation;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdTaiKhoan() {
        return idTaiKhoan;
    }

    public void setIdTaiKhoan(String idTaiKhoan) {
        this.idTaiKhoan = idTaiKhoan;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public Object getMaKhNavigation() {
        return maKhNavigation;
    }

    public void setMaKhNavigation(Object maKhNavigation) {
        this.maKhNavigation = maKhNavigation;
    }
}
