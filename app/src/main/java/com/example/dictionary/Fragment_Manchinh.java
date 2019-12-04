package com.example.dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


public class Fragment_Manchinh extends Fragment {
    private ImageButton imageDoi;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_manchinh, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDoi = view.findViewById(R.id.doi_AV);
        imageDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_ManVietAnh fragment_manVietAnh=new Fragment_ManVietAnh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manVietAnh).commit();

            }
        });

    }
}
