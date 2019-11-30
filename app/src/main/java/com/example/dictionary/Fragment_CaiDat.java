package com.example.dictionary;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment_CaiDat extends Fragment {
    private String mydata = "my_data";
    public String LangCode;
    private ImageView imageAnh, imageViet;
    private SharedPreferences sharedPreferences;
    Context context;

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
        //luu ngon ngu phan cai dat
        sharedPreferences = getActivity().getSharedPreferences(mydata, Context.MODE_PRIVATE);
        LangCode = sharedPreferences.getString("NgonNgu", "Viet");
        if (LangCode.equals("Viet")) {
            Toast.makeText(getActivity(), "Tiếng Việt", Toast.LENGTH_SHORT).show();
        }
        if (LangCode.equals("Anh")) {
            Toast.makeText(getActivity(), "Tiếng Anh", Toast.LENGTH_SHORT).show();

        }
        imageAnh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LangCode = "Anh";
                saveLangCode();
                Toast.makeText(getActivity(), "Tiếng Anh", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });
        imageViet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LangCode = "Viet";
                saveLangCode();
                Toast.makeText(getActivity(), "Tiếng Việt", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MainActivity.class));
            }
        });

    }

    public void saveLangCode() {
        //tạo đối tượng getSharedPreferences
        SharedPreferences pre = getActivity().getSharedPreferences(mydata, Context.MODE_PRIVATE);
        //tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor = pre.edit();
        editor.putString("NgonNgu", LangCode);
        //chấp nhận lưu xuống file
        editor.commit();
    }
}
