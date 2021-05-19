package com.example.app2.Data;

public class constant {
    public static final String DataBaseName = "my_db.db";
    public static final int DB_Version = 1;
    public static final String Table_Name = "rasxod";
    public static final String _ID = "_id";
    public static final String FOOD = "food";
    public static final String SHOPPING = "shopping";
    public static final String PRODUCTS = "products";
    public static final String TRANSPORT = "transport";
    public static final String ENTERTAIMENTS = "entertainments";
    public static final String HEALTH = "health";
    public static final String HOUSING = "housing";
    public static final String FIN_EXPENSES = "fin_expenses";
    public static final String OTHER1 = "other_ras";
    public static final String SALARY = "salary";
    public static final String INVESTMENT = "investment";
    public static final String OTHER2 = "other_dox";
    public static final String SUM_RAS = "sum_ras";
    public static final String SUM_DOX = "sum_dox";
    public static final String SUM_ALL = "sum_all";
    public static final String Table_Structure = "CREATE TABLE IF NOT EXISTS " + Table_Name + " (" +
            _ID + " INTEGER PRIMARY KEY," + FOOD + " INTEGER," + SHOPPING + " INTEGER," + PRODUCTS +" INTEGER,"+
            TRANSPORT + " INTEGER," + ENTERTAIMENTS + " INTEGER," + HEALTH + " INTEGER," + HOUSING + " INTEGER,"
            + FIN_EXPENSES + " INTEGER," + OTHER1 + " INTEGER,"+SALARY + " INTEGER,"+INVESTMENT+ " INTEGER,"+OTHER2+ " INTEGER,"+SUM_RAS+" INTEGER,"+SUM_DOX+" INTEGER,"+SUM_ALL+" INTEGER)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Table_Name;
}
