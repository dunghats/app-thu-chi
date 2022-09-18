package com.example.dell.quanly;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.dell.quanly.FragmentAdapter.QuanLyChiAdapter;
import com.google.android.material.tabs.TabLayout;

public class Quanly_Chi_Fragment extends Fragment {

    TabLayout tbqlchi;
    ViewPager vpqlchi;
    QuanLyChiAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.quanly_chi_layout,container,false);

        tbqlchi=view.findViewById(R.id.tbqlchi);
        vpqlchi=view.findViewById(R.id.vpqlchi);

        adapter=new QuanLyChiAdapter(getChildFragmentManager());

        vpqlchi.setAdapter(adapter);
        tbqlchi.setupWithViewPager(vpqlchi);


        return view;
    }
}
