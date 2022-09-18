package com.example.dell.quanly.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.dell.quanly.DatabaseManager;
import com.example.dell.quanly.R;

public class DiaLog_loaithu extends DialogFragment {
    private DatabaseManager manager;
    Button btkoaithu,bthuyloaithu;
    EditText edtloaithu;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.dialog_loaithu,container,false);

        btkoaithu=view.findViewById(R.id.btnthemloaithu);
        bthuyloaithu=view.findViewById(R.id.btnhuylt);
        edtloaithu=view.findViewById(R.id.edtloaithu);

        manager=new DatabaseManager(getActivity());

        bthuyloaithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        btkoaithu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String loaithu=edtloaithu.getText().toString();

                manager.insertLoaiThu(loaithu);
                getDialog().dismiss();
            }
        });


        return view;
    }
}
