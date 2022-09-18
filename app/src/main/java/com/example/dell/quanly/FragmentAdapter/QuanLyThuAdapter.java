package com.example.dell.quanly.FragmentAdapter;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.dell.quanly.Khoanthu_Frangment;
import com.example.dell.quanly.LoaiThu_Fragment;

public class QuanLyThuAdapter extends FragmentPagerAdapter {
    public QuanLyThuAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new Khoanthu_Frangment();

            case 1:
                return new LoaiThu_Fragment();

             default:
                 return new Khoanthu_Frangment();
        }


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        switch (position) {
            case 0:
                return "Khoản Thu";

            case 1:
                return "Loại Thu";

            default:
                return "Khoản Thu";
        }
    }
}
