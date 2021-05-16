package com.example.app2.Data;

public class constant {
    public static final String DataBaseName = "my_db.db";
    public static final int DB_Version = 1;
    public static final String Table_Name = "rasxod";
    public static final String _ID = "_id";
    public static final String FOOD = "food";
    public static final String PUBLIC_TRANSPORT = "public_transport";
    public static final String Table_Structure = "CREATE TABLE IF NOT EXISTS " + Table_Name + " (" +
            _ID + " INTEGER PRIMARY KEY," + FOOD + " TEXT," + PUBLIC_TRANSPORT + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Table_Name;
}
