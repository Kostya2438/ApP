package com.example.app2.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public DataBaseHelper(Context context) {
        super(context, constant.DataBaseName, null, constant.DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(constant.Table_Structure);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(constant.DROP_TABLE);
        onCreate(db);
    }

}
