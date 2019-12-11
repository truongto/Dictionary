package com.example.dictionary.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.dictionary.model.LichSu;
import com.example.dictionary.model.YeuThich;

import java.util.ArrayList;
import java.util.List;

public class SQLite extends SQLiteOpenHelper {

    public SQLite(@Nullable Context context) {
        super(context, "Tudien.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(LichSu.CREATE_TABLE_LICH_SU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + LichSu.TABLE_LICH_SU);
        sqLiteDatabase.execSQL(" DROP TABLE IF EXISTS " + YeuThich.TABLE_YEU_THICH);

    }
    public long inserLichSu(LichSu lichSu) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LichSu.COLUMN_ID, lichSu.getId());
        contentValues.put(LichSu.COLUMN_NOIDUNG, lichSu.getNoidung());
        contentValues.put(LichSu.COLUMN_NGAY, lichSu.getNgay());
        contentValues.put(LichSu.COLUMN_GIO, lichSu.getGio());
        long result = sqLiteDatabase.insert(LichSu.TABLE_LICH_SU, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }
    public List<LichSu> getAllLichSu() {
        List<LichSu> lichSus = new ArrayList<>();
        String SELECT = " SELECT * FROM " + LichSu.TABLE_LICH_SU;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_ID));
                String noidung = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_NOIDUNG));
                String ngay = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_NGAY));
                String gio = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_GIO));
                LichSu lichSu = new LichSu();
                lichSu.setId(id);
                lichSu.setNoidung(noidung);
                lichSu.setNgay(ngay);
                lichSu.setGio(gio);
                lichSus.add(lichSu);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return lichSus;
    }
    public void deleteLichSu(String idLichSu) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(LichSu.TABLE_LICH_SU, LichSu.COLUMN_ID + "=?", new String[]{String.valueOf(idLichSu)});
        db.close();
    }



    public long inserYeuThich(YeuThich yeuThich) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(YeuThich.COLUMN_ID, yeuThich.getId());
        contentValues.put(YeuThich.COLUMN_NOIDUNG, yeuThich.getNoidung());
        long result = sqLiteDatabase.insert(LichSu.TABLE_LICH_SU, null, contentValues);
        sqLiteDatabase.close();
        return result;
    }
    public List<YeuThich> getAllYeuThich() {
        List<YeuThich> thichList = new ArrayList<>();
        String SELECT = " SELECT * FROM " + YeuThich.TABLE_YEU_THICH;
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                String id = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_ID));
                String noidung = cursor.getString(cursor.getColumnIndex(LichSu.COLUMN_NOIDUNG));
                YeuThich yeuThich = new YeuThich();
                yeuThich.setId(id);
                yeuThich.setNoidung(noidung);
                thichList.add(yeuThich);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return thichList;
    }
    public void deleteYeuThich(String idLoaithu) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(YeuThich.TABLE_YEU_THICH, YeuThich.COLUMN_ID + "=?", new String[]{String.valueOf(idLoaithu)});
        db.close();
    }

}
