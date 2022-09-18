package com.example.dell.quanly.FragmentAdapter;



import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dell.quanly.KhoanChi_Fragment;
import com.example.dell.quanly.LoaiChi_Fragment;

public class QuanLyChiAdapter extends FragmentPagerAdapter {
    public QuanLyChiAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new KhoanChi_Fragment();
            case 1:
                return new LoaiChi_Fragment();
             default:
                 return new KhoanChi_Fragment();
        }

    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position){
            case 0:
                return "Khoản Chi";
            case 1:
                return "Loại Chi";
            default:
                return "Khoản Chi";
        }
    }
}
