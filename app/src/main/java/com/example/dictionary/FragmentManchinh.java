package com.example.dictionary;

import android.app.FragmentBreadCrumbs;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dictionary.adapter.TimkiemAV_Adapter;
import com.example.dictionary.data.Data_Dictionary;
import com.example.dictionary.databinding.FramentManchinhBindingImpl;
import com.example.dictionary.interfaceMVP.ManchinhView;
import com.example.dictionary.model.Word;
import com.example.dictionary.presenter.Manchinh_presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FragmentManchinh extends Fragment implements ManchinhView {
    private ImageButton imageDoi;
    private Data_Dictionary dataDictionary;
    private List<Word> wordList;
    private Context context;
    private TimkiemAV_Adapter avAdapter;
    private RecyclerView recyclerView;
    private ImageButton imageButton;
    private EditText editTextnhap;
    private Manchinh_presenter manchinh_presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
   View view = inflater.inflate(R.layout.frament_manchinh, container, false);

        FramentManchinhBindingImpl framentManchinhBinding =

        return container;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imageDoi = view.findViewById(R.id.doi_AV);
        recyclerView = view.findViewById(R.id.recy_timkiemAV);
        imageButton = view.findViewById(R.id.timAV);
        editTextnhap = view.findViewById(R.id.nhapAV);


        //doi fragment Anh Viet sang Viet Anh
        imageDoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment_ManVietAnh fragment_manVietAnh = new Fragment_ManVietAnh();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment, fragment_manVietAnh).commit();

            }
        });


    }

    @Override
    public void TimWord() {

    }

    @Override
    public void Laydulieu() {

    }
}