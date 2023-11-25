package com.example.huflittravel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Toast;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.huflittravel.databinding.ActivityLoginBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Console;
import java.io.IOException;
import java.time.Clock;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Credentials;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(Utils.SHARE_PREFERENCES_APP, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        getsavedLogin();
        setUpEvent();

    }

    private void setUpEvent() {
        binding.btnLogin.setOnClickListener(v -> login());
        binding.btnRegis.setOnClickListener(v -> register());


    }

    private void register() {
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    private void login() {

        String usname = binding.edLoginUsername.getEditText().getText().toString().trim();
        String pass = binding.edLoginPassword.getEditText().getText().toString().trim();
        OkHttpClient client = new OkHttpClient();
        String y = "https://huflittravel.somee.com";

        HttpUrl.Builder urlBuilder = HttpUrl.parse(y + "/api/DangNhap").newBuilder();
        urlBuilder.addQueryParameter("username", usname);
        urlBuilder.addQueryParameter("password", pass);
        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(null, new byte[0])) // Empty body
                .addHeader("accept", "*/*")
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                boolean flag = true;
                int x = 0;
                if (response != null && !response.isSuccessful()) {
                    x = response.code();
                }
                if (x == 400) {
                    runOnUiThread(() -> {
                        Toast.makeText(LoginActivity.this, "Lỗi kết nối", Toast.LENGTH_SHORT).show();
                    });
                    return;
                }
                if (x == 401) {
                    runOnUiThread(() -> {
                        Toast.makeText(LoginActivity.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                    });
                    return;
                }
                String responseBody = response.body().string();
                try {
                    TimeUnit.SECONDS.sleep(2); // Wait for 30 seconds
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    JSONObject jsonResponse = new JSONObject(responseBody);
                    String token = jsonResponse.getString("token");
                    String secretKey = "zzzzhdz02x1ta1urertv01vwxchjb4h1";

                    try {
                        Algorithm algorithm = Algorithm.HMAC512(secretKey);
                        DecodedJWT decodedJWT = JWT.require(algorithm)
                                .build()
                                .verify(token);
                        String role = decodedJWT.getClaim("role").asString();
                        String email = decodedJWT.getClaim("email").asString();
                        String id = decodedJWT.getClaim("id").asString();
                        editor.putString(Utils.USER_ROLE, role);
                        editor.putString(Utils.USER_EMAIL, email);
                        editor.putString(Utils.USER_ID, id);
                        editor.commit();
                        toMain();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        });
    }

    private void toMain() {
        savedLogin();
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        LoginActivity.this.finish();
        startActivity(i);
    }

    private void getsavedLogin() {
        String usnSaved = sharedPreferences.getString(Utils.ACCOUNT_RMB_US_LOGIN, "");
        String uspSaved = sharedPreferences.getString(Utils.ACCOUNT_RMB_PASS, "");
        if (usnSaved.isEmpty())
            return;
        binding.cbGhiNhoDN.setChecked(true);
        binding.edLoginUsername.getEditText().setText(usnSaved);
        binding.edLoginPassword.getEditText().setText(uspSaved);

        binding.edLoginUsername.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.cbGhiNhoDN.setChecked(false);
                binding.edLoginPassword.getEditText().setText(null);
            }
        });
    }

    void savedLogin() {
        if (binding.cbGhiNhoDN.isChecked()) {
            String savedLUSn = binding.edLoginUsername.getEditText().getText().toString().trim();
            String savedLUSp = binding.edLoginPassword.getEditText().getText().toString().trim();
            editor.putString(Utils.ACCOUNT_RMB_US_LOGIN, savedLUSn);
            editor.putString(Utils.ACCOUNT_RMB_PASS, savedLUSp);
            editor.commit();
        } else if (!binding.cbGhiNhoDN.isChecked()) {
            editor.remove(Utils.ACCOUNT_RMB_US_LOGIN);
            editor.remove(Utils.ACCOUNT_RMB_PASS);
            editor.commit();
        }
    }
}