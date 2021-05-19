package com.example.app2.ui.home;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.app2.AddEntry;
import com.example.app2.Data.DbManager;
import com.example.app2.MAINMENU;
import com.example.app2.R;
import com.example.app2.Startscreen;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Button rasxod,doxod;
    ImageButton add1,add2,add3,add4,add5,add6,add7,add8,add9,add10,add11,add12;
    TextView balance_ras,balance_dox,balance_m;
    private DbManager dbManager;
    Context thiscontext;
    HorizontalBarChart hor_chart;
    AddEntry addetry = new AddEntry();
    FragmentTransaction traf;
    int[] colors = new int[]{Color.BLUE,Color.RED,Color.GREEN};
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
        balance_m=(TextView)view.findViewById(R.id.balance_m);
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

        View.OnClickListener lis=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                traf = getFragmentManager().beginTransaction();
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
                    case R.id.add_shopping:
                    case R.id.add_products:
                    case R.id.add_trasnport:
                    case R.id.add_entertainments:
                    case R.id.add_health:
                    case R.id.add_housing:
                    case R.id.add_fin_expenses:
                    case R.id.add_other_ras:
                    case R.id.add_salary:
                    case R.id.add_investment:
                    case R.id.add_other_dox:
                        traf.replace(R.id.frgmCont,addetry);
                        break;
                }
                traf.commit();
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

    private void setData(int money,int key){
        ArrayList<BarEntry> yValues = new ArrayList<>();
        float barwidth = 1f;
        float spaceForBar = 2f;
        yValues.add(new BarEntry(key*spaceForBar,10));
        BarDataSet set1 = new BarDataSet(yValues,"");
        ArrayList<IBarDataSet> barDataSets1 = new ArrayList<>();
        barDataSets1.add(set1);
        BarData data= new BarData(barDataSets1);
        data.setBarWidth(barwidth);
        hor_chart.setData(data);
    }
}