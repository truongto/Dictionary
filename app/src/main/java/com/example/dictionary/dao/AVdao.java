package com.example.dictionary.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dictionary.data.Data_Dictionary;
import com.example.dictionary.model.Word;

import java.util.ArrayList;
import java.util.List;

public class AVdao {
    private Data_Dictionary dataDictionary;
    private SQLiteDatabase db;
    private String AV_TABLE = "av";

    public String ID = "id";
    public String WORD = "word";
    public String HTML = "html";
    public String DES = "description";
    public String PRO = "pronounce";

    public AVdao(Context context){
       dataDictionary=new Data_Dictionary(context);
        db=dataDictionary.getWritableDatabase();
    }

    public List<Word> searchWord(String text) {
        List<Word> words = new ArrayList<>();

        String SQL = "SELECT * FROM " + AV_TABLE + " WHERE " + WORD + " LIKE '" + text + "%'";

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
    public Word searchWordByName(String text) {
        Word word = new Word();
        String SQL = "SELECT * FROM " + AV_TABLE + " WHERE " + WORD + " LIKE '" + text + "'";

        Cursor cursor = db.rawQuery(SQL, null);

        if (cursor != null) {
            if (cursor.getCount() > 0) {

                cursor.moveToFirst();
                while (!cursor.isAfterLast()) {

                    word.id = cursor.getInt(cursor.getColumnIndex(ID));
                    word.word = cursor.getString(cursor.getColumnIndex(WORD));
                    word.description = cursor.getString(cursor.getColumnIndex(DES));
                    word.html = cursor.getString(cursor.getColumnIndex(HTML));
                    word.pronounce = cursor.getString(cursor.getColumnIndex(PRO));

                    cursor.moveToNext();

                }
                cursor.close();
            }
        }

        return word;
    }
}
