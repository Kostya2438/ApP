package com.example.app2.ui.home;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;;
import androidx.lifecycle.ViewModelProviders;

import com.example.app2.Data.DbManager;
import com.example.app2.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    Button rasxod,doxod;
    private DbManager dbManager;

    Context thiscontext;
    EditText ras,dox;
    TextView dan;
    Button press;

    HorizontalBarChart hor_chart;
    int[] colors = new int[]{Color.BLUE,Color.RED,Color.GREEN};
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rasxod = (Button)view.findViewById(R.id.rasxod);
        doxod = (Button)view.findViewById(R.id.doxod);

        thiscontext = container.getContext();
        ras=(EditText)view.findViewById(R.id.ras);
        dox=(EditText)view.findViewById(R.id.dox);
        dan=(TextView)view.findViewById(R.id.textView2);
        press=(Button)view.findViewById(R.id.press);

        dbManager = new DbManager(getActivity());
        hor_chart=(HorizontalBarChart)view.findViewById(R.id.hor_bar_chart);
        View.OnClickListener listener=new View.OnClickListener() {
            @Override
            public void onClick(View v){
                switch(v.getId()){
                    case R.id.rasxod:
                        rasxod.setBackgroundResource(R.color.but_press_rasx);
                        doxod.setBackgroundResource(R.color.but_not_press_dox);
                        break;
                    case R.id.doxod:
                        doxod.setBackgroundResource(R.color.but_press_dox);
                        rasxod.setBackgroundResource(R.color.but_not_press_rasx);
                        break;
                    case R.id.press:
                        dan.setText("");
                        dbManager.insertToDb(ras.getText().toString());
                        for (Integer g: dbManager.getFromDbSumm()){
                            dan.append(String.valueOf(g));
                            dan.append("\n");
                        }
                }
            }
        };
        rasxod.setOnClickListener(listener);
        doxod.setOnClickListener(listener);
        hor_chart.getDescription().setEnabled(false);
        hor_chart.getLegend().setEnabled(false);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        dbManager.openDb();
        for (Integer g: dbManager.getFromDbSumm()){
            dan.append(String.valueOf(g));
            dan.append("\n");
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        dbManager.closeDb();
    }

    private void setData(int money, Entry e){
        ArrayList<BarEntry> yValues = new ArrayList<>();
        float barwidth = 1f;
        float spaceForBar = 2f;
        yValues.add(new BarEntry(3*spaceForBar,4));
        yValues.add(new BarEntry(5*spaceForBar,8));
        yValues.add(new BarEntry(3*spaceForBar,10));
        BarDataSet set1;
        set1 = new BarDataSet(yValues,"");
        ArrayList<IBarDataSet> barDataSets1 = new ArrayList<>();
        barDataSets1.add(set1);
        BarData data= new BarData(barDataSets1);
        data.setBarWidth(barwidth);
        hor_chart.setData(data);

    }
}