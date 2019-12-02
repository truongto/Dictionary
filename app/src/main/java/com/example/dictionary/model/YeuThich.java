package com.example.dictionary.model;

public class YeuThich {
    String id;
    String noidung;



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
    public static final String TABLE_YEU_THICH= "Yeuthich";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NOIDUNG = "noidung";


    public static final String CREATE_TABLE_YEU_THICH = " CREATE TABLE " + TABLE_YEU_THICH + " ( " + COLUMN_ID +
            " INTEGER PRIMARY KEY, " + COLUMN_NOIDUNG + " VARCHAR, )";

}
