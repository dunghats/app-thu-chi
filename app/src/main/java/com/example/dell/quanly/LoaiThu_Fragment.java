package com.example.dell.quanly;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dell.quanly.dialog.DiaLog_loaithu;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class LoaiThu_Fragment extends Fragment {
    ListView lvloaithu;
    FloatingActionButton flloaithu;
    DatabaseManager manager;
    Cursor cursor;
    private android.widget.SimpleCursorAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.loaithu_layout,container,false);

        lvloaithu=view.findViewById(R.id.lvloaithu);
        flloaithu=view.findViewById(R.id.flloaithu);
        manager = new DatabaseManager(getActivity());
        hienthi();
        cursor = manager.getLoaiThu();

        if (cursor != null) {
            adapter = new android.widget.SimpleCursorAdapter(getActivity(),
                    R.layout.xulythuchi_layout,
                    cursor,
                    new String[]{"LoaiThu"},
                    new int[]{R.id.tvten});

          //  lvloaithu.setAdapter(adapter);

        }
        lvloaithu.setAdapter(adapter);
        adapter.notifyDataSetChanged();




            flloaithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DiaLog_loaithu diaLog_loaithu=new DiaLog_loaithu();
                diaLog_loaithu.show(getFragmentManager(),"dialog");
            }
        });




        return view;
    }

    private void hienthi() {
        cursor = manager.getLoaiThu();

        if (cursor != null) {
            adapter = new android.widget.SimpleCursorAdapter(getActivity(),
                    R.layout.xulythuchi_layout,
                    cursor,
                    new String[]{"LoaiThu"},
                    new int[]{R.id.tvten});

            lvloaithu.setAdapter(adapter);

        }
        adapter.notifyDataSetChanged();
    }

}
