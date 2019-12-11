package com.example.dictionary.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dictionary.data.DataDictionary;
import com.example.dictionary.model.Word;

import java.util.ArrayList;
import java.util.List;

public class VAdao {
    private DataDictionary dataDictionary;
    private SQLiteDatabase db;
    private String VA_TABLE = "va";

    public String ID = "id";
    public String WORD = "word";
    public String HTML = "html";
    public String DES = "description";
    public String PRO = "pronounce";

    public VAdao(Context context){
        dataDictionary=new DataDictionary(context);
        db=dataDictionary.getWritableDatabase();
    }
    public List<Word> searchVA(String text) {
        List<Word> words = new ArrayList<>();
        String SQL = "SELECT * FROM " + VA_TABLE + " WHERE " + WORD + " LIKE '" + text + "%'";

        Cursor cursor = db.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    Word word = new Word();
                    word.id = cursor.getInt(cursor.getColumnIndex(ID));
                    word.word = cursor.getString(cursor.getColumnIndex(WORD));
                    word.description = cursor.getString(cursor.getColumnIndex(DES));
                    word.html = cursor.getString(cursor.getColumnIndex(HTML));
                    word.pronounce = cursor.getString(cursor.getColumnIndex(PRO));
                    words.add(word);
                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return words;
    }
}
