package com.example.dictionary;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.dictionary.interfaceMVP.ManchinhView;
import com.example.dictionary.presenter.Manchinh_Presenter;

public class Fragment_Manchinh extends Fragment implements ManchinhView {
    Manchinh_Presenter manchinh_presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frament_manchinh, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        manchinh_presenter = new Manchinh_Presenter(this);

    }
}
