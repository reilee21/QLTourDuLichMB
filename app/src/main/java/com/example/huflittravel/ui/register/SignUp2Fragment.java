package com.example.huflittravel.ui.register;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.huflittravel.R;
import com.example.huflittravel.RegisterActivity;
import com.example.huflittravel.databinding.FragmentSignUp1Binding;
import com.example.huflittravel.databinding.FragmentSignUp2Binding;
import com.example.huflittravel.models.Account;
import com.google.android.material.textfield.TextInputLayout;


public class SignUp2Fragment extends Fragment {
    FragmentSignUp2Binding binding;
    View v;
    RegisterActivity registerActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUp2Binding.inflate(inflater, container, false);
        v = binding.getRoot();
        binding.btnBackForm1.setOnClickListener(v -> back());
        binding.btnSignup.setOnClickListener(v -> onSubmit());
        return v;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        registerActivity = (RegisterActivity) context;

    }

    public void onSubmit() {
        String usname = binding.tilUsername.getEditText().getText().toString().trim();
        String pass = binding.tilPassword.getEditText().getText().toString().trim();
        String repass = binding.tilReenterPassword.getEditText().getText().toString().trim();

        boolean usnameValid = validateAndSetError(binding.tilUsername, usname, "Username không hợp lệ");
        boolean passValid = validateAndSetError(binding.tilPassword, pass, "Mật khẩu không hợp lệ");
        boolean repassValid = validateAndSetError(binding.tilReenterPassword, repass, "Nhập lại mật khẩu không chính xác");

        if (usnameValid && passValid && repassValid) {
            if (usname.length() > 15) {
                binding.tilUsername.setError("Username không được quá 15 ký tự");
                return;
            } else {
                binding.tilUsername.setError(null);
            }
            if (!pass.equals(repass)) {
                binding.tilReenterPassword.setError("Mật khẩu không khớp");
                return;
            } else {
                binding.tilReenterPassword.setError(null);
            }
            Account acc = new Account(usname, pass);
            registerActivity.setInfoAccount(acc);
            registerActivity.onSubmit();
        }


    }

    public void back() {
        registerActivity.onBackButtonClick();
    }

    private boolean validateAndSetError(TextInputLayout textInputLayout, String text, String errorMessage) {
        if (text.length() < 3) {
            textInputLayout.setError(errorMessage);
            return false;
        } else {
            textInputLayout.setError(null);
            return true;
        }
    }
}