package com.example.dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //khi vao app hien len man chinh
        Fragment_Manchinh fragment_manchinh = new Fragment_Manchinh();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment, fragment_manchinh).commit();
        //bat su kien vao menubottom
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.navigation_home:
                        Toast.makeText(MainActivity.this, "home", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_dashboard:
                        Toast.makeText(MainActivity.this, "dashboard", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.navigation_notifications:
                        Toast.makeText(MainActivity.this, "notificatios", Toast.LENGTH_LONG).show();
                        return true;
                }
                return false;
            }
        });

    }

}
