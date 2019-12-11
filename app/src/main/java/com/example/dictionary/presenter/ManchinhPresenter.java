package com.example.dictionary.presenter;

import com.example.dictionary.interfaceMVP.ManchinhView;

public class ManchinhPresenter {
    private ManchinhView manchinhView;

    public ManchinhPresenter(ManchinhView manchinhView) {
        this.manchinhView = manchinhView;
    }

    public void Tim() {
        manchinhView.TimWord();
    }
}
