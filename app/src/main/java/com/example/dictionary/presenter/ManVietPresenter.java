package com.example.dictionary.presenter;

import com.example.dictionary.FragmentManVietAnh;
import com.example.dictionary.interfaceMVP.ManVietAnhView;

public class ManVietPresenter {
private ManVietAnhView manVietAnhView;

    public ManVietPresenter(ManVietAnhView manVietAnhView) {
        this.manVietAnhView = manVietAnhView;
    }

    public void TimVA() {
        manVietAnhView.TimVietAnh();
    }
}
