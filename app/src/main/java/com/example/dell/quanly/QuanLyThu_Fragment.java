package com.example.dell.quanly;

        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import androidx.viewpager.widget.ViewPager;

        import com.example.dell.quanly.FragmentAdapter.QuanLyThuAdapter;
        import com.google.android.material.tabs.TabLayout;

public class QuanLyThu_Fragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    QuanLyThuAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.quanly_thu_layout,container,false);

        tabLayout=view.findViewById(R.id.tbqlythu);
        viewPager=view.findViewById(R.id.vpquanlythu);

        adapter=new QuanLyThuAdapter(getChildFragmentManager());

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}
