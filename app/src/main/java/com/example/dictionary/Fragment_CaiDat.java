package com.example.dictionary;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Fragment_CaiDat extends Fragment {
    private String mydata = "my_data";
    public String LangCode;
    private ImageView imageAnh, imageViet;
    private TextView textView;
    private SharedPreferences sharedPreferences;
    BottomNavigationView bottomNavigationView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_caidat, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageAnh = view.findViewById(R.id.ngonnguAnh);
        imageViet = view.findViewById(R.id.ngonnguViet);
        textView = view.findViewById(R.id.tv_caidat);
        bottomNavigationView = view.findViewById(R.id.bottom_navigation);

        //luu ngon ngu phan cai dat
        sharedPreferences = this.getActivity().getSharedPreferences(mydata, Context.MODE_PRIVATE);
        LangCode = sharedPreferences.getString("NgonNgu", "Viet");
        if (LangCode.equals("Viet")) {
            Toast.makeText(getActivity(), "Tiếng Việt", Toast.LENGTH_SHORT).show();
        }
        if (LangCode.equals("Anh")) {
            Toast.makeText(getActivity(), "Tiếng Anh", Toast.LENGTH_SHORT).show();
        }

        //chuyen ngon ngu de dich
        imageAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LangCode = "Anh";
                saveLangCode();
                textView.setText("Choose The Language");
                Fragment_Manchinh fragment_manchinh = new Fragment_Manchinh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manchinh).commit();
//                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        imageViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LangCode = "Viet";
                saveLangCode();
                textView.setText("Chọn Ngôn Ngữ");
                Fragment_ManVietAnh fragment_manVietAnh = new Fragment_ManVietAnh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manVietAnh).commit();
//                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

    }
    public void saveLangCode() {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre = this.getActivity().getSharedPreferences(mydata, Context.MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor = pre.edit();
        editor.putString("NgonNgu", LangCode);
        //chấp nhận lưu xuống file
        editor.commit();
    }

}
