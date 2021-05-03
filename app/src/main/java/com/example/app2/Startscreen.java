package com.example.app2;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Startscreen extends AppCompatActivity {
    EditText name;
    Button button_start;
    public static String user_name;
    TextView cur_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.startscreen);
        name = (EditText)findViewById(R.id.name);
        cur_name = (TextView)findViewById(R.id.notcurrname);
        button_start = (Button)findViewById(R.id.button_start);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.button_start:
                        user_name = name.getText().toString();
                        if (TextUtils.isEmpty(user_name)){
                            cur_name.setText("Неправильно введено имя");
                        }
                        else{
                            user_name = name.getText().toString();
                            Intent intent_main = new Intent(Startscreen.this, MAINMENU.class);
                            intent_main.putExtra("person_name",user_name);
                            startActivity(intent_main);
                        }
                }
            }
        };
        button_start.setOnClickListener(listener);
    }
}