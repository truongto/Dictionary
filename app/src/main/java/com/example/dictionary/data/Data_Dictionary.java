package com.example.dictionary.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import com.example.dictionary.model.Word;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Data_Dictionary extends SQLiteOpenHelper {
    private static String TAG = "TuDienDatabase";
    //tên cơ sở dữ liệu
    public static String NAME = "dict_hh.db";
    //dịa chỉ lưu trữ CSDL
    public static String DB_PATH = null;
    private SQLiteDatabase mDataBase;
    Context mContext;

    private String AV_TABLE = "av";
    private String VA_TABLE = "va";

    public String ID = "id";
    public String WORD = "word";
    public String HTML = "html";
    public String DES = "description";
    public String PRO = "pronounce";

    public Data_Dictionary(@Nullable Context context) {
        super(context, NAME, null, 1);
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            DB_PATH = context.getApplicationInfo().dataDir + "/databases/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";
        }
        this.mContext = context;
    }


    public boolean checkDataBase() {
        File dbFile = new File(DB_PATH + NAME);
        return dbFile.exists();
    }

    public void createDataBase() throws IOException {
        boolean mDataBaseExits = checkDataBase();
        if (!mDataBaseExits) {
            this.getReadableDatabase();
            this.close();
            try{
                copyDataBase();
                Log.e(TAG, "createDatabase database created");
            } catch (IOException mIOException) {
                throw new Error("Error Copying DataBase");
            }
        }
    }
    public void copyDataBase() throws IOException {
        InputStream mInput = mContext.getAssets().open(NAME);
        String outFileName = DB_PATH + NAME;
        OutputStream mOutput = new FileOutputStream(outFileName);
        byte[] mBuffer = new byte[1024];
        int mLength;
        while ((mLength = mInput.read(mBuffer)) > 0) {
            mOutput.write(mBuffer, 0, mLength);
        }
        mOutput.flush();
        mOutput.close();
        mInput.close();
    }


    public boolean openDataBase() throws SQLException {
        String mPath = DB_PATH + NAME;
        //Log.v("mPath", mPath);
        mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.CREATE_IF_NECESSARY);
        //mDataBase = SQLiteDatabase.openDatabase(mPath, null, SQLiteDatabase.NO_LOCALIZED_COLLATORS);
        return mDataBase != null;
    }

    @Override
    public synchronized void close() {
        if (mDataBase != null)
            mDataBase.close();
        super.close();
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
