package com.example.dell.quanly;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText edtusename;
    EditText edtmk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtusename = findViewById(R.id.edtusename);
        edtmk = findViewById(R.id.edtmk);

    }
    public void dangnhap(View view) {

        SharedPreferences pref = getSharedPreferences("dangnhap", MODE_PRIVATE);

        String ten = pref.getString("taikhoan", "abc");
        String mk = pref.getString("matkhau", "123");
        String name = edtusename.getText().toString();
        String pasw = edtmk.getText().toString();

        if (!name.equalsIgnoreCase(ten) || !pasw.equalsIgnoreCase(mk)) {
            Toast.makeText(this, "Tên tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
        } else if (name.equalsIgnoreCase("") || pasw.equalsIgnoreCase("")) {
            Toast.makeText(this, "vui lòng nhập đủ thông tin", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(MainActivity.this,ThongkeActivity.class));
        }


    }

    public void dangki(View view) {
        final Dialog dialog = new Dialog(this);

        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dangki_item);

        final EditText tendn = dialog.findViewById(R.id.tendn);
        final EditText mk = dialog.findViewById(R.id.mk);
        Button xacnhan = dialog.findViewById(R.id.xacnhan);

        xacnhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("dangnhap", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();

                String tk = tendn.getText().toString().trim();
                String pass = mk.getText().toString().trim();

                editor.putString("taikhoan", tk);
                editor.putString("matkhau", pass);

                editor.commit();
                Toast.makeText(MainActivity.this, "Đăng Kí Thành Công", Toast.LENGTH_SHORT).show();
                dialog.cancel();


            }
        });
        dialog.show();


    }
}
