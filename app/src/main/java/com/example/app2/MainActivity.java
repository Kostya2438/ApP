package com.example.app2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "mysettings";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SharedPreferences sp = getSharedPreferences(APP_PREFERENCES,
                Context.MODE_PRIVATE);
        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    TimeUnit.SECONDS.sleep(2);
                    boolean hasVisited = sp.getBoolean("hasVisited", true);
                    if (hasVisited) {
                        SharedPreferences.Editor e = sp.edit();
                        if (sp.getBoolean("hasVisited",true)) {
                            e.putBoolean("hasVisited", false);
                            e.commit();
                        }
                        Intent intent2 = new Intent(MainActivity.this, Startscreen.class);
                        startActivity(intent2);
                    }
                    else{
                        Intent intent_main = new Intent(MainActivity.this, MAINMENU.class);
                        startActivity(intent_main);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        thread.start();

    }
}