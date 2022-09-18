package com.example.dell.quanly;

import android.database.Cursor;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dell.quanly.Adapter.Xuly;
import com.example.dell.quanly.dialog.DiaLog_KhoanThu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Khoanthu_Frangment extends Fragment {
    ListView lvthu;
    FloatingActionButton flthem;
    ArrayAdapter<Xuly> arrayAdapter;
    DatabaseManager manager;
    private Cursor cursor;
    private SimpleCursorAdapter adapter;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.khoanthu_layout, container, false);

        lvthu = view.findViewById(R.id.lvthu);
        flthem = view.findViewById(R.id.flthem);

        manager = new DatabaseManager(getActivity());

        cursor = manager.getKhoanThu();
        if (cursor != null) {
            adapter = new SimpleCursorAdapter(getActivity(),
                    R.layout.khoanthu_dialog,
                    cursor,
                    new String[]{"KhoanThu", "SoTien","NgayThang"},
                    new int[]{R.id.tvkt, R.id.tvgia,R.id.tvngaythang});


            lvthu.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        }


        flthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLog_KhoanThu diaLog_khoanThu = new DiaLog_KhoanThu();
                diaLog_khoanThu.show(getFragmentManager(), "dialog");

            }
        });

        return view;


    }

}
