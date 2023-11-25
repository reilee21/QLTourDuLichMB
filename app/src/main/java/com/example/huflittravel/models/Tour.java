package com.example.huflittravel.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Tour implements Serializable {
    @Override
    public String toString() {
        return "Tour{" +
                "maTour='" + maTour + '\'' +
                ", tenTour='" + tenTour + '\'' +
                ", soLuongNguoi=" + soLuongNguoi +
                ", soLuongNguoiDaDat=" + soLuongNguoiDaDat +
                ", ngayKhoiHanh='" + ngayKhoiHanh + '\'' +
                ", soNgay=" + soNgay +
                ", soDem=" + soDem +
                ", noiKhoiHanh='" + noiKhoiHanh + '\'' +
                ", gioTapTrung='" + gioTapTrung + '\'' +
                ", gia=" + gia +
                ", anhBia='" + anhBia
                ;
    }

    @SerializedName("maTour")
    @Expose
    private String maTour;
    @SerializedName("tenTour")
    @Expose
    private String tenTour;
    @SerializedName("soLuongNguoi")
    @Expose
    private Integer soLuongNguoi;
    @SerializedName("soLuongNguoiDaDat")
    @Expose
    private Integer soLuongNguoiDaDat;
    @SerializedName("ngayKhoiHanh")
    @Expose
    private String ngayKhoiHanh;
    @SerializedName("soNgay")
    @Expose
    private Integer soNgay;
    @SerializedName("soDem")
    @Expose
    private Integer soDem;
    @SerializedName("noiKhoiHanh")
    @Expose
    private String noiKhoiHanh;
    @SerializedName("gioTapTrung")
    @Expose
    private String gioTapTrung;
    @SerializedName("gia")
    @Expose
    private Integer gia;
    @SerializedName("anhBia")
    @Expose
    private String anhBia;
    @SerializedName("image")
    @Expose
    private Object image;
    @SerializedName("bookingTours")
    @Expose
    private List<Object> bookingTours;
    @SerializedName("danhGia")
    @Expose
    private List<Object> danhGia;
    @SerializedName("lichTrinhs")
    @Expose
    private List<Object> lichTrinhs;
    @SerializedName("tourKhuyenMais")
    @Expose
    private List<Object> tourKhuyenMais;
    @SerializedName("tourPhuongTiens")
    @Expose
    private List<Object> tourPhuongTiens;

    public String getMaTour() {
        return maTour;
    }

    public void setMaTour(String maTour) {
        this.maTour = maTour;
    }

    public String getTenTour() {
        return tenTour;
    }

    public void setTenTour(String tenTour) {
        this.tenTour = tenTour;
    }

    public Integer getSoLuongNguoi() {
        return soLuongNguoi;
    }

    public void setSoLuongNguoi(Integer soLuongNguoi) {
        this.soLuongNguoi = soLuongNguoi;
    }

    public Integer getSoLuongNguoiDaDat() {
        return soLuongNguoiDaDat;
    }

    public void setSoLuongNguoiDaDat(Integer soLuongNguoiDaDat) {
        this.soLuongNguoiDaDat = soLuongNguoiDaDat;
    }

    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public Integer getSoNgay() {
        return soNgay;
    }

    public void setSoNgay(Integer soNgay) {
        this.soNgay = soNgay;
    }

    public Integer getSoDem() {
        return soDem;
    }

    public void setSoDem(Integer soDem) {
        this.soDem = soDem;
    }

    public String getNoiKhoiHanh() {
        return noiKhoiHanh;
    }

    public void setNoiKhoiHanh(String noiKhoiHanh) {
        this.noiKhoiHanh = noiKhoiHanh;
    }

    public String getGioTapTrung() {
        return gioTapTrung;
    }

    public void setGioTapTrung(String gioTapTrung) {
        this.gioTapTrung = gioTapTrung;
    }

    public Integer getGia() {
        return gia;
    }

    public void setGia(Integer gia) {
        this.gia = gia;
    }

    public String getAnhBia() {
        return anhBia;
    }

    public void setAnhBia(String anhBia) {
        this.anhBia = anhBia;
    }

    public Object getImage() {
        return image;
    }

    public void setImage(Object image) {
        this.image = image;
    }

    public List<Object> getBookingTours() {
        return bookingTours;
    }

    public void setBookingTours(List<Object> bookingTours) {
        this.bookingTours = bookingTours;
    }

    public List<Object> getDanhGia() {
        return danhGia;
    }

    public void setDanhGia(List<Object> danhGia) {
        this.danhGia = danhGia;
    }

    public List<Object> getLichTrinhs() {
        return lichTrinhs;
    }

    public void setLichTrinhs(List<Object> lichTrinhs) {
        this.lichTrinhs = lichTrinhs;
    }

    public List<Object> getTourKhuyenMais() {
        return tourKhuyenMais;
    }

    public void setTourKhuyenMais(List<Object> tourKhuyenMais) {
        this.tourKhuyenMais = tourKhuyenMais;
    }

    public List<Object> getTourPhuongTiens() {
        return tourPhuongTiens;
    }

    public void setTourPhuongTiens(List<Object> tourPhuongTiens) {
        this.tourPhuongTiens = tourPhuongTiens;
    }
}
