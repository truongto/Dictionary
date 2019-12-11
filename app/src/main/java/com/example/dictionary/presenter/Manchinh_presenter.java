package com.example.dictionary.presenter;

import com.example.dictionary.interfaceMVP.ManchinhView;

public class Manchinh_presenter {
    private ManchinhView manchinhView;

    public Manchinh_presenter(ManchinhView manchinhView) {
        this.manchinhView = manchinhView;
    }

    public void Tim(){
        manchinhView.TimWord();
    }
    public void Data(){
       manchinhView.Laydulieu();
    }
}
