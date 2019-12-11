package com.example.dictionary.model;

public class LichSu {
    String id ;
    String noidung;
    String ngay;
    String gio;


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
    public static final String TABLE_LICH_SU= "Lichsu";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOIDUNG = "noidung";
    public static final String COLUMN_NGAY = "ngay";
    public static final String COLUMN_GIO = "gio";

    public static final String CREATE_TABLE_LICH_SU = " CREATE TABLE " + TABLE_LICH_SU + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_NOIDUNG + " VARCHAR, " + COLUMN_NGAY + " VARCHAR, " + COLUMN_GIO + " VARCHAR ) ";

}
