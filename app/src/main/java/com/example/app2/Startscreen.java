package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Startscreen extends AppCompatActivity {
    Button button_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        button_start = (Button)findViewById(R.id.button_start);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.button_start:
                        Intent intent_main = new Intent(Startscreen.this, MAINMENU.class);;
                        startActivity(intent_main);
                }
            }
        };
        button_start.setOnClickListener(listener);
    }

    @Override
    public void onBackPressed(){}
}
