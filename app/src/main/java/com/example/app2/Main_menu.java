package com.example.app2;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Main_menu extends AppCompatActivity {
    //public static final String APP_PREFERENCES = "mysettings";
    //private SharedPreferences sharedPrefs;
    SharedPreferences.Editor ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        //sharedPrefs=getSharedPreferences(APP_PREFERENCES,MODE_PRIVATE);
        //boolean hasVisited = sharedPrefs.getBoolean("hasVisited", false);
        //if (!hasVisited) {
        //    SharedPreferences.Editor e = sharedPrefs.edit();
          //  e.putBoolean("hasVisited", true);
           // e.commit();
        //}
    }
}
