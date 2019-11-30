package com.example.dictionary.model;

public class YeuThich {
    String id;
    String noidung;

    public YeuThich(String id, String noidung) {
        this.id = id;
        this.noidung = noidung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }
}
