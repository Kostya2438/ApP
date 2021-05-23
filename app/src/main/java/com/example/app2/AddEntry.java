package com.example.app2;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app2.Data.DbManager;
import com.example.app2.ui.home.HomeFragment;
import com.github.mikephil.charting.charts.HorizontalBarChart;

public class AddEntry extends AppCompatActivity {
    HorizontalBarChart hor_chart;
    DbManager dbManager;
    private Button btnComma;
    private ImageButton btnClear;
    private ImageButton btnDivide;
    private ImageButton btnMultiply;
    private ImageButton btnSubtract;
    private ImageButton add_cursum;
    private ImageButton back;
    private ImageButton btnAddition;
    private ImageButton btnEquals;
    private TextView resultView;
    private Button[] buttons = new Button[10];
    private float oldNumber;
    private char operation = '0';
    HomeFragment homeFragment = new HomeFragment();
    TextView category,category_1;
    ImageView image_cat;
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences sharedPrefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addentry);
        category=(TextView)findViewById(R.id.category);
        category_1=(TextView)findViewById(R.id.category_1);
        image_cat=(ImageView)findViewById(R.id.image_cat);
        add_cursum=(ImageButton)findViewById(R.id.add_cursum);
        back=(ImageButton)findViewById(R.id.back);

        hor_chart=(HorizontalBarChart)findViewById(R.id.hor_bar_chart);
        dbManager = new DbManager(this);
        final Intent intent = new Intent(this,  MAINMENU.class);
        final SharedPreferences sp = getSharedPreferences(APP_PREFERENCES,
                MODE_PRIVATE);
        sharedPrefs = getSharedPreferences(APP_PREFERENCES, MODE_PRIVATE);
        int categoty = sp.getInt("categoty", 0);
        final Bundle arguments = getIntent().getExtras();
        final SharedPreferences.Editor e = sp.edit();
        if (sp.getInt("category", 0) == 1) {
            category.setText("Доход");
        }
        else
            category.setText("Расход");
        switch (arguments.get("cat").toString()){
            case "1":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_food));
                category_1.setText("Еда");
                break;
            case "2":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_shopping));
                category_1.setText("Шоппинг");
                break;
            case "3":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_products));
                category_1.setText("Продукты");
                break;
            case "4":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_transport));
                category_1.setText("Транспорт");
                break;
            case "5":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_enter));
                category_1.setText("Развлечения");
                break;
            case "6":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_health));
                category_1.setText("Здоровье");
                break;
            case "7":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_housing));
                category_1.setText("Жильё");
                break;
            case "8":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.fin_exp));
                category_1.setText("Фин расходы");
                break;
            case "9":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_other));
                category_1.setText("Другое Расходы");
                break;
            case "10":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_salary));
                category_1.setText("Зарплата");
                break;
            case "11":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_invest));
                category_1.setText("Инвестиции");
                break;
            case "12":
                image_cat.setImageDrawable(getResources().getDrawable(R.drawable.image_other2));
                category_1.setText("Другое Доходы");
                break;
        }

        View.OnClickListener lis=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.add_cursum:
                        if (Integer.parseInt(resultView.getText().toString())!=0) {
                            dbManager.insertToDb(Integer.parseInt(resultView.getText().toString()), (int) arguments.get("cat"));
                            startActivity(intent);
                        }
                        break;
                    case R.id.back:
                        startActivity(intent);
                        break;
                }
            }
        };
        add_cursum.setOnClickListener(lis);
        back.setOnClickListener(lis);

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initFields();

        Resources res = getResources();

        for(int i = 0; i < buttons.length; i++){
            String id = "btn" + i;

            buttons[i] = (Button) findViewById(res.getIdentifier(id, "id", getPackageName()));
        }

        for (int i = 0; i < buttons.length; i++){
            buttons[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    changeViewText(view.getResources().getResourceName(view.getId()));
                }
            });
        }

        btnComma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String result = resultView.getText().toString();
                if( ! result.contains(".")){
                    resultView.append(".");
                }
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                equalsMethod(true);
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                resultView.setText("0");
                operation = '0';
                oldNumber = 0;
                changeButtonState(true);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                changeOperation('/');
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOperation('*');
            }
        });

        btnSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOperation('-');
            }
        });

        btnAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeOperation('+');
            }
        });
    }

    private void initFields(){
        btnComma = (Button) findViewById(R.id.btnComma);
        btnClear = (ImageButton) findViewById(R.id.btnClear);
        btnDivide = (ImageButton) findViewById(R.id.btnDivide);
        btnMultiply = (ImageButton) findViewById(R.id.btnMultiply);
        btnSubtract = (ImageButton) findViewById(R.id.btnSubtract);
        btnAddition = (ImageButton) findViewById(R.id.btnAddition);
        btnEquals = (ImageButton) findViewById(R.id.btnEquals);
        resultView = (TextView) findViewById(R.id.cur_sum);
        oldNumber = 0;
    }

    private void changeOperation(char execute){
        if(operation == '0'){
            operation = execute;
            oldNumber = Float.parseFloat(resultView.getText().toString());
            resultView.setText("0");
        } else {
            equalsMethod(false);
            operation = execute;
        }

        if( ! btnComma.isEnabled()){
            changeButtonState(true);
        }
    }

    private void changeViewText(String id){
        float total = Float.parseFloat(resultView.getText().toString());
        id = String.valueOf(id.charAt(id.length() - 1));

        appeandTextResult(id, total);
    }

    private void appeandTextResult(String id, float number){
        if (number == 0) {
            resultView.setText(id);
        } else {
            resultView.append(id);
        }
    }

    public float divide(float x, float y){
        if ((x/y)<0)
            return 0;
        return x / y;
    }

    public float mulitply(float x, float y){
        if ((x*y)<0)
            return 0;
        return x * y;
    }

    public float subtract(float x, float y){
        if ((x-y)<0)
            return 0;
        return x - y;
    }

    public float addition(float x, float y){
        if ((x+y)<0)
            return 0;
        return x + y;
    }

    public void equalsMethod(boolean isFinal){
        if (operation == '0') return;

        float current = Float.parseFloat(resultView.getText().toString());

        if(current == 0) return;

        oldNumber = getResult(current);

        if (isFinal){
            resultView.setText(String.valueOf(oldNumber));
            operation = '0';
            changeButtonState(false);
        } else {
            resultView.setText(String.valueOf("0"));
        }
    }

    public float getResult(float current){
        switch(operation){
            case '*':
                return mulitply(current, oldNumber);
            case '/':
                return divide(oldNumber, current);
            case '-':
                return subtract(oldNumber, current);
            case '+':
                return addition(current, oldNumber);
            default:
                return oldNumber;
        }
    }

    private void changeButtonState(boolean stateChange){
        for (int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(stateChange);
        }

        btnComma.setEnabled(stateChange);
    }

    @Override
    protected void onResume() {
        super.onResume();
        dbManager.openDb();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbManager.closeDb();
    }
}

