package com.example.dictionary.model;

public class LichSu {
    String id ;
    String noidung;
    String ngay;
    String gio;

    public LichSu(String id, String noidung, String ngay, String gio) {
        this.id = id;
        this.noidung = noidung;
        this.ngay = ngay;
        this.gio = gio;
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

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getGio() {
        return gio;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }
}
