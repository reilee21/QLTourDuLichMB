package com.example.huflittravel.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.huflittravel.MainActivity;
import com.example.huflittravel.ui.main.AccountFragment;
import com.example.huflittravel.ui.main.HomeFragment;

public class ScreenSlidePageAdapter extends FragmentStateAdapter {
    public ScreenSlidePageAdapter(@NonNull MainActivity mainActivity) {
        super(mainActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new HomeFragment();
            case 1:
                return new AccountFragment();
            default:
                return new HomeFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

}
