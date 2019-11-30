package com.example.dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.app.Notification;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        toolbar = findViewById(R.id.toolbar_manchinh);
        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Dictionary");

        //khi vao app hien len man chinh
        Fragment_Manchinh fragment_manchinh = new Fragment_Manchinh();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment, fragment_manchinh).commit();

        //bat su kien vao menubottom
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ManChinh:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment_Manchinh())
                                .commit();
                        return true;
                    case R.id.YeuThich:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment_YeuThich())
                                .commit();
                        return true;
                    case R.id.LichSu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment_Lichsu())
                                .commit();
                        return true;
                    case R.id.CaiDat:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new Fragment_CaiDat())
                                .commit();
                        return true;
                }
                return false;
            }
        });

    }

}
