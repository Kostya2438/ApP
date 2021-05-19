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

    public DbManager(Context context) {
        this.context = context;
        dataBaseHelper = new DataBaseHelper(context);
    }

    public void openDb() {
        db = dataBaseHelper.getWritableDatabase();
    }

    public void insertToDb(int value,int key) {
        ContentValues cv = new ContentValues();
        switch (key){
            case 1:
                cv.put(constant.FOOD, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 2:
                cv.put(constant.SHOPPING, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 3:
                cv.put(constant.PRODUCTS, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 4:
                cv.put(constant.TRANSPORT, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 5:
                cv.put(constant.ENTERTAIMENTS, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 6:
                cv.put(constant.HEALTH, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 7:
                cv.put(constant.HOUSING, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 8:
                cv.put(constant.FIN_EXPENSES, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 9:
                cv.put(constant.OTHER1, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,-value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_RAS, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 10:
                cv.put(constant.SALARY, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_DOX, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 11:
                cv.put(constant.INVESTMENT, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_DOX, value);
                db.insert(constant.Table_Name, null, cv);
                break;
            case 12:
                cv.put(constant.OTHER2, value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_ALL,value);
                db.insert(constant.Table_Name, null, cv);
                cv.clear();
                cv.put(constant.SUM_DOX, value);
                db.insert(constant.Table_Name, null, cv);
                break;
        }
    }

    public List<String> getFromDb() {
        List<String> templist = new ArrayList<>();
        Cursor cursor = db.query(constant.Table_Name, null, null, null,
                null, null, null);
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(constant.FOOD));
            templist.add(title);
        }
        cursor.close();
        return templist;
    }
    public List<Integer> getFromDbSum() {
        List<Integer> templist = new ArrayList<>();
        Cursor cursor = db.rawQuery("SELECT SUM(food) as food FROM " + constant.Table_Name, null);
        while (cursor.moveToNext()) {
                int title = cursor.getInt(cursor.getColumnIndex(constant.FOOD));
                templist.add(title);
        }
        cursor.close();
        return templist;
    }
    public int getFromDbSumRasxod() {
        int value = 0;
        Cursor cursor = db.rawQuery("SELECT SUM(sum_ras) as sum_ras FROM " + constant.Table_Name, null);
        while (cursor.moveToNext()) {
            int title = cursor.getInt(cursor.getColumnIndex(constant.SUM_RAS));
            value = title;
        }
        cursor.close();
        return value;
    }
    public int getFromDbSumDoxod() {
        int value = 0;
        Cursor cursor = db.rawQuery("SELECT SUM(sum_dox) as sum_dox FROM " + constant.Table_Name, null);
        while (cursor.moveToNext()) {
            int title = cursor.getInt(cursor.getColumnIndex(constant.SUM_DOX));
            value = title;
        }
        cursor.close();
        return value;
    }
    public int getFromDbAllSum() {
        int value = 0;
        Cursor cursor = db.rawQuery("SELECT SUM(sum_all) as sum_all FROM " + constant.Table_Name, null);
        while (cursor.moveToNext()) {
            int title = cursor.getInt(cursor.getColumnIndex(constant.SUM_ALL));
            value = title;
        }
        cursor.close();
        return value;
    }
    public void closeDb(){
        dataBaseHelper.close();
    }

}
