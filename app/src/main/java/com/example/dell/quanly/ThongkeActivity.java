package com.example.dell.quanly;


import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;


public class ThongkeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navthongke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongke);

        drawerLayout = findViewById(R.id.drawerlayout);
        navthongke = findViewById(R.id.navthongke);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Thongke_Fragment()).commit();
        navthongke.setCheckedItem(R.id.thongke);
        navthongke.setNavigationItemSelectedListener(ThongkeActivity.this);


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        switch (item.getItemId()){
            case R.id.khoanthu:
               getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new QuanLyThu_Fragment()).commit();
               break;

            case R.id.khoanchi:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Quanly_Chi_Fragment()).commit();
                break;

            case R.id.thongke:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Thongke_Fragment()).commit();
                break;


            case R.id.thoat:
               finish();
                break;

                default:
                    getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Thongke_Fragment()).commit();
                    break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
