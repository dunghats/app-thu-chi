package com.example.dell.quanly;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dell.quanly.dialog.DiaLogKhoanChi;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class KhoanChi_Fragment extends Fragment {
    ListView lvkhoanchi;
    FloatingActionButton flkhoanchi;
    DatabaseManager manager;
    Cursor cursor;
    SimpleCursorAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.khoanchi_fragment,container,false);

        lvkhoanchi=view.findViewById(R.id.lvkhoanchi);
        flkhoanchi=view.findViewById(R.id.flkhoanchi);

        manager = new DatabaseManager(getActivity());


        cursor = manager.getKhoanChi();
        if (cursor != null) {
            adapter = new SimpleCursorAdapter(getActivity(),
                    R.layout.khoanthu_dialog,
                    cursor,
                    new String[]{"KhoanChi", "ChiPhi","NgayThang"},
                    new int[]{R.id.tvkt, R.id.tvgia,R.id.tvngaythang});



            lvkhoanchi.setAdapter(adapter);


        }
        adapter.notifyDataSetChanged();


        flkhoanchi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLogKhoanChi diaLogKhoanChi=new DiaLogKhoanChi();
                diaLogKhoanChi.show(getFragmentManager(),"dialog");
            }
        });

        return view;
    }
}
