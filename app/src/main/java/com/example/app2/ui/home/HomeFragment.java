package com.example.app2.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;;
import androidx.lifecycle.ViewModelProviders;

import com.example.app2.AddEntry;
import com.example.app2.Data.DbManager;
import com.example.app2.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;

public class HomeFragment extends Fragment {
    Button rasxod,doxod;
    ImageButton add1,add2,add3,add4,add5,add6,add7,add8,add9,add10,add11,add12;
    TextView balance_ras,balance_dox,balance_m,balance_food,balance_shopping,balance_products,balance_transport,balance_entertainments,balance_health,balance_housing,balance_fin_expenses,
    balance_other_ras,balance_salary,balance_invest,balance_other_dox;
    private DbManager dbManager;
    Context thiscontext;
    HorizontalBarChart hor_chart;
    public static final String APP_PREFERENCES = "mysettings";
    private SharedPreferences sharedPrefs;
    int[] colors = new int[]{Color.rgb(66,170,255),Color.rgb(255,165,0),Color.rgb(255,143,162),Color.rgb(139,0,0),
    Color.rgb(0,128,0),Color.rgb(79,0,122),Color.rgb(150,85,0),Color.rgb(255,255,0),Color.BLACK,Color.rgb(0,219,106),
    Color.GRAY,Color.rgb(0,0,245)};
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rasxod = (Button)view.findViewById(R.id.rasxod);
        doxod = (Button)view.findViewById(R.id.doxod);
        balance_ras=(TextView) view.findViewById(R.id.balance_ras);
        balance_dox=(TextView) view.findViewById(R.id.balance_dox);
        balance_m=(TextView)view.findViewById(R.id.balance_m2);
        balance_food=(TextView) view.findViewById(R.id.balance_food);
        balance_shopping=(TextView) view.findViewById(R.id.balance_shopping);
        balance_products=(TextView) view.findViewById(R.id.balance_products);
        balance_transport=(TextView)view.findViewById(R.id.balance_transport);
        balance_entertainments=(TextView) view.findViewById(R.id.balance_entertainments);
        balance_health=(TextView) view.findViewById(R.id.balance_health);
        balance_housing=(TextView) view.findViewById(R.id.balance_housing);
        balance_fin_expenses=(TextView) view.findViewById(R.id.balance_fin_expenses);
        balance_other_ras=(TextView) view.findViewById(R.id.balance_other_ras);
        balance_salary=(TextView) view.findViewById(R.id.balance_salary);
        balance_invest=(TextView) view.findViewById(R.id.balance_investment);
        balance_other_dox=(TextView) view.findViewById(R.id.balance_other_dox);
        hor_chart=(HorizontalBarChart)view.findViewById(R.id.hor_bar_chart);
        add1=(ImageButton)view.findViewById(R.id.add_food);
        add2=(ImageButton)view.findViewById(R.id.add_shopping);
        add3=(ImageButton)view.findViewById(R.id.add_products);
        add4=(ImageButton)view.findViewById(R.id.add_trasnport);
        add5=(ImageButton)view.findViewById(R.id.add_entertainments);
        add6=(ImageButton)view.findViewById(R.id.add_health);
        add7=(ImageButton)view.findViewById(R.id.add_housing);
        add8=(ImageButton)view.findViewById(R.id.add_fin_expenses);
        add9=(ImageButton)view.findViewById(R.id.add_other_ras);
        add10=(ImageButton)view.findViewById(R.id.add_salary);
        add11=(ImageButton)view.findViewById(R.id.add_investment);
        add12=(ImageButton)view.findViewById(R.id.add_other_dox);
        thiscontext = container.getContext();
        dbManager = new DbManager(getActivity());
        dbManager.openDb();
        balance_m.setText(String.valueOf(dbManager.getFromDbAllSum())+" Р");
        balance_food.setText(String.valueOf(dbManager.getFromDbSumFood())+" Р");
        balance_shopping.setText(String.valueOf(dbManager.getFromDbSumShopping())+" Р");
        balance_products.setText(String.valueOf(dbManager.getFromDbSumProducts())+" Р");
        balance_transport.setText(String.valueOf(dbManager.getFromDbSumTransport())+" Р");
        balance_entertainments.setText(String.valueOf(dbManager.getFromDbSumEntertainments())+" Р");
        balance_health.setText(String.valueOf(dbManager.getFromDbSumHealth())+" Р");
        balance_housing.setText(String.valueOf(dbManager.getFromDbSumHousing())+" Р");
        balance_fin_expenses.setText(String.valueOf(dbManager.getFromDbSumFin_expenses())+" Р");
        balance_other_ras.setText(String.valueOf(dbManager.getFromDbSumOther_ras())+" Р");
        balance_salary.setText(String.valueOf(dbManager.getFromDbSumSalary())+" Р");
        balance_invest.setText(String.valueOf(dbManager.getFromDbSumInvest())+" Р");
        balance_other_dox.setText(String.valueOf(dbManager.getFromDbSumOther_dox())+" Р");
        final SharedPreferences sp = this.getActivity().getSharedPreferences(APP_PREFERENCES,
                MODE_PRIVATE);
        sharedPrefs=this.getActivity().getSharedPreferences(APP_PREFERENCES,MODE_PRIVATE);
        final SharedPreferences.Editor e = sp.edit();
        e.putInt("category",0);
        e.commit();
        final Intent intent = new Intent(HomeFragment.this.getActivity(), AddEntry.class);
        View.OnClickListener lis=new View.OnClickListener() {
                        @Override
                        public void onClick(View v){
                            switch(v.getId()){
                                case R.id.rasxod:
                        rasxod.setBackgroundResource(R.color.but_press_rasx);
                        doxod.setBackgroundResource(R.color.but_not_press_dox);
                        balance_ras.setText(String.valueOf(dbManager.getFromDbSumRasxod())+" Р");
                        balance_dox.setText("");
                        balance_m.setText(String.valueOf(dbManager.getFromDbAllSum())+" Р");
                        break;
                    case R.id.doxod:
                        doxod.setBackgroundResource(R.color.but_press_dox);
                        rasxod.setBackgroundResource(R.color.but_not_press_rasx);
                        balance_dox.setText(String.valueOf(dbManager.getFromDbSumDoxod())+" Р");
                        balance_ras.setText("");
                        balance_m.setText(String.valueOf(dbManager.getFromDbAllSum())+" Р");
                        break;
                    case R.id.add_food:
                        intent.putExtra("cat",1);
                        startActivity(intent);
                        break;
                    case R.id.add_shopping:
                        intent.putExtra("cat",2);
                        startActivity(intent);
                        break;
                    case R.id.add_products:
                        intent.putExtra("cat",3);
                        startActivity(intent);
                        break;
                    case R.id.add_trasnport:
                        intent.putExtra("cat",4);
                        startActivity(intent);
                        break;
                    case R.id.add_entertainments:
                        intent.putExtra("cat",5);
                        startActivity(intent);
                        break;
                    case R.id.add_health:
                        intent.putExtra("cat",6);
                        startActivity(intent);
                        break;
                    case R.id.add_housing:
                        intent.putExtra("cat",7);
                        startActivity(intent);
                        break;
                    case R.id.add_fin_expenses:
                        intent.putExtra("cat",8);
                        startActivity(intent);
                        break;
                    case R.id.add_other_ras:
                        intent.putExtra("cat",9);
                        startActivity(intent);
                        break;
                    case R.id.add_salary:
                        intent.putExtra("cat",10);
                        e.putInt("category",1);
                        e.commit();
                        startActivity(intent);
                        break;
                    case R.id.add_investment:
                        intent.putExtra("cat",11);
                        e.putInt("category",1);
                        e.commit();
                        startActivity(intent);
                        break;
                    case R.id.add_other_dox:
                        intent.putExtra("cat",12);
                        e.putInt("category",1);
                        e.commit();
                        startActivity(intent);
                        break;
                }
            }
        };
        rasxod.setOnClickListener(lis);
        doxod.setOnClickListener(lis);
        hor_chart.getDescription().setEnabled(false);
        hor_chart.getLegend().setEnabled(false);
        add1.setOnClickListener(lis);
        add2.setOnClickListener(lis);
        add3.setOnClickListener(lis);
        add4.setOnClickListener(lis);
        add5.setOnClickListener(lis);
        add6.setOnClickListener(lis);
        add7.setOnClickListener(lis);
        add8.setOnClickListener(lis);
        add9.setOnClickListener(lis);
        add10.setOnClickListener(lis);
        add11.setOnClickListener(lis);
        add12.setOnClickListener(lis);
        setData();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        dbManager.openDb();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbManager.closeDb();
    }

    public void setData(){
        ArrayList<BarEntry> yValues = new ArrayList<>();
        float barwidth = 1.4f;
        float spaceForBar = 2f;
        yValues.add(new BarEntry(1*spaceForBar,dbManager.getFromDbSumFood()));
        yValues.add(new BarEntry(2*spaceForBar,dbManager.getFromDbSumShopping()));
        yValues.add(new BarEntry(3*spaceForBar,dbManager.getFromDbSumProducts()));
        yValues.add(new BarEntry(4*spaceForBar,dbManager.getFromDbSumTransport()));
        yValues.add(new BarEntry(5*spaceForBar,dbManager.getFromDbSumEntertainments()));
        yValues.add(new BarEntry(6*spaceForBar,dbManager.getFromDbSumHealth()));
        yValues.add(new BarEntry(7*spaceForBar,dbManager.getFromDbSumHousing()));
        yValues.add(new BarEntry(8*spaceForBar,dbManager.getFromDbSumFin_expenses()));
        yValues.add(new BarEntry(9*spaceForBar,dbManager.getFromDbSumOther_ras()));
        yValues.add(new BarEntry(10*spaceForBar,dbManager.getFromDbSumSalary()));
        yValues.add(new BarEntry(11*spaceForBar,dbManager.getFromDbSumInvest()));
        yValues.add(new BarEntry(12*spaceForBar,dbManager.getFromDbSumOther_dox()));
        BarDataSet set1 = new BarDataSet(yValues,"");
        set1.setColors(colors);
        BarData data= new BarData(set1);
        data.setBarWidth(barwidth);
        hor_chart.setData(data);
    }
}