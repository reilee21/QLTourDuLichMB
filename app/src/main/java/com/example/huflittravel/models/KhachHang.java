package com.example.huflittravel.models;

public class KhachHang {
    public KhachHang(String ten, String sdt, String email, String dchi) {
        this.id = "";
        this.ten = ten;
        this.sdt = sdt;
        this.email = email;
        this.dchi = dchi;
    }

    private String id, ten, sdt, email, dchi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDchi() {
        return dchi;
    }

    public void setDchi(String dchi) {
        this.dchi = dchi;
    }
}
