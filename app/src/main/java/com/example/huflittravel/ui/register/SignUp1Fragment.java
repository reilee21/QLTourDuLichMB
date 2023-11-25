package com.example.huflittravel.ui.register;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.huflittravel.LoginActivity;
import com.example.huflittravel.R;
import com.example.huflittravel.RegisterActivity;
import com.example.huflittravel.databinding.FragmentHomeBinding;
import com.example.huflittravel.databinding.FragmentSignUp1Binding;
import com.example.huflittravel.models.KhachHang;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;


public class SignUp1Fragment extends Fragment {
    FragmentSignUp1Binding binding;
    View v;
    RegisterActivity registerActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSignUp1Binding.inflate(inflater, container, false);
        v = binding.getRoot();
        binding.btnNextF2.setOnClickListener(v -> onNextButtonClick());

        return v;
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        registerActivity = (RegisterActivity) context;

    }

    public void onNextButtonClick() {
        String ten = binding.tilName.getEditText().getText().toString().trim();
        String sdt = binding.tilPhone.getEditText().getText().toString().trim();
        String email = binding.tilEmail.getEditText().getText().toString().trim();
        String dchi = binding.tilAddress.getEditText().getText().toString().trim();
        boolean tenValid = validateAndSetError(binding.tilName, ten, "Tên không hợp lệ");
        boolean sdtValid = validateAndSetError(binding.tilPhone, sdt, "Số điện thoại không hợp lệ");
        boolean emailValid = validateAndSetError(binding.tilEmail, email, "Email không hợp lệ");
        boolean dchiValid = validateAndSetError(binding.tilAddress, dchi, "Địa chỉ không hợp lệ");

        if (tenValid && sdtValid && emailValid && dchiValid) {
            if (checkEmailType(email)) {
                KhachHang k = new KhachHang(ten, sdt, email, dchi);
                registerActivity.setInfoKH(k);
                registerActivity.onNextButtonClick();
            } else {
                binding.tilEmail.setError("Email không hợp lệ");
            }

        }
    }

    private boolean checkEmailType(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pat.matcher(email).matches();
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