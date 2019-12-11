package com.example.dictionary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    private Toolbar toolbar;
    private ImageView imageViet, imageAnh;
    private String mydata = "my_data";
    String LangCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        toolbar = findViewById(R.id.toolbar_manchinh);
        imageViet = findViewById(R.id.icon_Viet);
        imageAnh = findViewById(R.id.icon_Anh);

        //toolbar
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Dictionary");

        //khi vao app hien len man chinh
        FragmentManchinh fragment_manchinh = new FragmentManchinh();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.fragment, fragment_manchinh).commit();

        //bat su kien vao menubottom
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.ManChinh:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment, new FragmentManchinh())
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

//chuyen ngon cho bottomMenu
        SharedPreferences sharedPreferences = getSharedPreferences(mydata, MODE_PRIVATE);
        LangCode = sharedPreferences.getString("NgonNgu", "Viet");
        imageAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLangCode();
                LangCode = "Anh";
                bottomNavigationView.getMenu().findItem(R.id.ManChinh).setTitle("Translate");
                bottomNavigationView.getMenu().findItem(R.id.YeuThich).setTitle("Favorite");
                bottomNavigationView.getMenu().findItem(R.id.LichSu).setTitle("History");
                bottomNavigationView.getMenu().findItem(R.id.CaiDat).setTitle("Setting");
            }
        });
        imageViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveLangCode();
                LangCode = "Viet";
                bottomNavigationView.getMenu().findItem(R.id.ManChinh).setTitle("Dịch");
                bottomNavigationView.getMenu().findItem(R.id.YeuThich).setTitle("Yêu Thích");
                bottomNavigationView.getMenu().findItem(R.id.LichSu).setTitle("Lịch Sử");
                bottomNavigationView.getMenu().findItem(R.id.CaiDat).setTitle("Cài Đặt");

            }
        });
        if (LangCode.equals("Viet")) {
            bottomNavigationView.getMenu().findItem(R.id.ManChinh).setTitle("Dịch");
            bottomNavigationView.getMenu().findItem(R.id.YeuThich).setTitle("Yêu Thích");
            bottomNavigationView.getMenu().findItem(R.id.LichSu).setTitle("Lịch Sử");
            bottomNavigationView.getMenu().findItem(R.id.CaiDat).setTitle("Cài Đặt");
        }
        if (LangCode.equals("Anh")) {
            bottomNavigationView.getMenu().findItem(R.id.ManChinh).setTitle("Translate");
            bottomNavigationView.getMenu().findItem(R.id.YeuThich).setTitle("Favorite");
            bottomNavigationView.getMenu().findItem(R.id.LichSu).setTitle("History");
            bottomNavigationView.getMenu().findItem(R.id.CaiDat).setTitle("Setting");
        }

    }

    public void saveLangCode() {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre = getSharedPreferences(mydata, MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor = pre.edit();
        editor.putString("NgonNgu", LangCode);
        //chấp nhận lưu xuống file
        editor.commit();
    }

}
