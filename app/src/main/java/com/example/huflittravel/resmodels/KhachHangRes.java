package com.example.huflittravel.resmodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class KhachHangRes {
    @SerializedName("hoTen")
    @Expose
    private String hoTen;
    @SerializedName("soDienThoaiKh")
    @Expose
    private String soDienThoaiKh;
    @SerializedName("ngaySinh")
    @Expose
    private String ngaySinh;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("soCccd")
    @Expose
    private Object soCccd;
    @SerializedName("maPassport")
    @Expose
    private Object maPassport;
    @SerializedName("diaChi")
    @Expose
    private String diaChi;
    @SerializedName("maKh")
    @Expose
    private String maKh;
    @SerializedName("diemThuong")
    @Expose
    private Object diemThuong;
    @SerializedName("bookings")
    @Expose
    private List<Object> bookings;
    @SerializedName("danhGia")
    @Expose
    private List<Object> danhGia;
    @SerializedName("taiKhoans")
    @Expose
    private List<Object> taiKhoans;

    @Override
    public String toString() {
        return "KhachHangRes{" +
                "hoTen='" + hoTen + '\'' +
                ", soDienThoaiKh='" + soDienThoaiKh + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", email='" + email + '\'' +
                ", soCccd=" + soCccd +
                ", maPassport=" + maPassport +
                ", diaChi='" + diaChi + '\'' +
                ", maKh='" + maKh + '\'' +
                ", diemThuong=" + diemThuong +
                ", bookings=" + bookings +
                ", danhGia=" + danhGia +
                ", taiKhoans=" + taiKhoans +
                '}';
    }

    public KhachHangRes(String hoTen, String soDienThoaiKh, String ngaySinh, String email, String diaChi, String maKh) {
        this.hoTen = hoTen;
        this.soDienThoaiKh = soDienThoaiKh;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.maKh = maKh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoaiKh() {
        return soDienThoaiKh;
    }

    public void setSoDienThoaiKh(String soDienThoaiKh) {
        this.soDienThoaiKh = soDienThoaiKh;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Object getSoCccd() {
        return soCccd;
    }

    public void setSoCccd(Object soCccd) {
        this.soCccd = soCccd;
    }

    public Object getMaPassport() {
        return maPassport;
    }

    public void setMaPassport(Object maPassport) {
        this.maPassport = maPassport;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaKh() {
        return maKh;
    }

    public void setMaKh(String maKh) {
        this.maKh = maKh;
    }

    public Object getDiemThuong() {
        return diemThuong;
    }

    public void setDiemThuong(Object diemThuong) {
        this.diemThuong = diemThuong;
    }

    public List<Object> getBookings() {
        return bookings;
    }

    public void setBookings(List<Object> bookings) {
        this.bookings = bookings;
    }

    public List<Object> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(List<Object> danhGia) {
        this.danhGia = danhGia;
    }

    public List<Object> getTaiKhoans() {
        return taiKhoans;
    }

    public void setTaiKhoans(List<Object> taiKhoans) {
        this.taiKhoans = taiKhoans;
    }
}
