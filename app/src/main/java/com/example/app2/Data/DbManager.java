package com.example.app2.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DbManager {
    private Context context;
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;

    public DbManager(Context context){
        this.context=context;
        dataBaseHelper = new DataBaseHelper(context);
    }
    public void openDb(){
        db = dataBaseHelper.getWritableDatabase();
    }
    public void insertToDb(String food){
        ContentValues cv = new ContentValues();
        cv.put(constant.FOOD,food);
        db.insert(constant.Table_Name,null,cv);
    }
    public List<String> getFromDb(){
        List<String> templist = new ArrayList<>();
        Cursor cursor = db.query(constant.Table_Name, null,null,null,
                null,null,null);
        while(cursor.moveToNext()){
            String title = cursor.getString(cursor.getColumnIndex(constant.FOOD));
            templist.add(title);
        }
        cursor.close();
        return templist;
    }
    public List<Integer> getFromDbSumm(){
        List<Integer> templist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT SUM(FOOD) FROM "+constant.FOOD,null);
        Integer res = Integer.parseInt(String.valueOf(cursor));
        templist.add(res);
        cursor.close();
        return templist;
    }
    public void closeDb(){
        dataBaseHelper.close();
    }

}
