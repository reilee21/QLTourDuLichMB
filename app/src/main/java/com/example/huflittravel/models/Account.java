package com.example.huflittravel.models;

import java.io.Serializable;

public class Account implements Serializable {
    String Username;
    String Password;
    String MaKh;

    public Account(String username, String password) {
        Username = username;
        Password = password;
        MaKh = "";
    }


    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getMaKh() {
        return MaKh;
    }

    public void setMaKh(String maKh) {
        MaKh = maKh;
    }
}
