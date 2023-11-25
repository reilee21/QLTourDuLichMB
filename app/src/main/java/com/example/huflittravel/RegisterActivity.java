package com.example.huflittravel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.huflittravel.databinding.ActivityLoginBinding;
import com.example.huflittravel.databinding.ActivityRegisterBinding;
import com.example.huflittravel.models.Account;
import com.example.huflittravel.models.DiaDiem;
import com.example.huflittravel.models.KhachHang;
import com.example.huflittravel.resmodels.AccountRes;
import com.example.huflittravel.resmodels.KhachHangRes;
import com.example.huflittravel.services.Api;
import com.example.huflittravel.services.ApiClient;
import com.example.huflittravel.ui.register.SignUp1Fragment;
import com.example.huflittravel.ui.register.SignUp2Fragment;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import kotlin.jvm.Throws;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegisterActivity extends AppCompatActivity {
    ActivityRegisterBinding binding;
    SignUp1Fragment signUp1Fragment;
    SignUp2Fragment signUp2Fragment;
    KhachHang infoKH;
    Account account;

    public void setInfoKH(KhachHang k) {
        infoKH = new KhachHang(k.getTen(), k.getSdt(), k.getEmail(), k.getDchi());
    }

    public void setInfoAccount(Account acc) {
        account = new Account(acc.getUsername(), acc.getPassword());
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        signUp1Fragment = new SignUp1Fragment();
        signUp2Fragment = new SignUp2Fragment();

        setupEvent();
    }

    private void setupEvent() {
        loadFragment(signUp1Fragment);
        setFC(1);
    }

    void loadFragment(Fragment fmNew) {
        FragmentTransaction fmTran = getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.fragRegis, fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }

    public void onNextButtonClick() {
        setFC(2);
        loadFragment(signUp2Fragment);
    }

    public void onBackButtonClick() {
        setFC(1);
        loadFragment(signUp1Fragment);
    }

    public void onSubmit() {
        registerCustomer(infoKH);
    }

    private void setFC(int i) {
        if (i == 1) {
            binding.tvf1.setTextSize(28);
            binding.tvf2.setTextSize(24);
            binding.tvf1.setTextColor(getResources().getColor(R.color.xanhduong));
            binding.tvf2.setTextColor(getResources().getColor(R.color.xam));
            return;
        }
        binding.tvf2.setTextSize(28);
        binding.tvf1.setTextSize(24);
        binding.tvf2.setTextColor(getResources().getColor(R.color.xanhduong));
        binding.tvf1.setTextColor(getResources().getColor(R.color.xam));
    }

    private void registerCustomer(KhachHang k) {
        Instant instant = Instant.now();
        KhachHangRes newkh = new KhachHangRes(k.getTen(), k.getSdt(), instant.toString(), k.getEmail(), k.getDchi(), "demox");
        Call<KhachHangRes> call = ApiClient.getInstance().getMyApi().ThemKhachHang(newkh);
        call.enqueue(new Callback<KhachHangRes>() {
            @Override
            public void onResponse(Call<KhachHangRes> call, Response<KhachHangRes> response) {
                if (response.isSuccessful()) {
                    KhachHangRes khachHangResponse = response.body();
                    if (khachHangResponse != null) {
                        AccountRes newacc = new AccountRes(account.getUsername(), account.getPassword(), "x", khachHangResponse.getMaKh(), khachHangResponse);
                        addTaiKhoan(newacc);
                    }

                } else {
                    try {
                        Log.i("khachHangResponse-er", "Loi roi" + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<KhachHangRes> call, Throwable t) {
                Log.i("khachHangResponse-failcall", "Loi roi");

            }
        });


    }


    private void addTaiKhoan(AccountRes acc) {
        Call<AccountRes> call = ApiClient.getInstance().getMyApi().registerAccount(acc);
        call.enqueue(new Callback<AccountRes>() {
            @Override
            public void onResponse(Call<AccountRes> call, Response<AccountRes> response) {
                if (response.isSuccessful()) {
                    AccountRes accountRes = response.body();
                    if (accountRes != null) {
                        Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                        Toast.makeText(RegisterActivity.this, "Tạo tài khoản thành công", Toast.LENGTH_SHORT).show();

                        startActivity(i);
                    }

                } else {
                    try {
                        Log.i("AccountRes-er", "Loi roi" + response.errorBody().string());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }

            @Override
            public void onFailure(Call<AccountRes> call, Throwable t) {

            }
        });
    }
}

