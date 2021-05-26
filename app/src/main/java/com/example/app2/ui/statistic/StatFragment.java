package com.example.app2.ui.statistic;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.app2.Data.DbManager;
import com.example.app2.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

import java.util.ArrayList;

public class StatFragment extends Fragment {

    private StatViewModel galleryViewModel;
    TextView balance_m2;
    private DbManager dbManager;
    PieChart pieChart;
    BarChart barchart;
    int[] colors = new int[]{Color.rgb(66,170,255),Color.rgb(255,165,0),Color.rgb(255,143,162),Color.rgb(139,0,0),
            Color.rgb(0,128,0),Color.rgb(79,0,122),Color.rgb(150,85,0),Color.rgb(235,235,0),Color.BLACK,Color.rgb(0,219,106),
            Color.GRAY,Color.rgb(0,0,245)};
    int[] colors1 = new int[]{Color.RED,Color.GREEN};
    String[] label = new String[]{"Расходы","Доходы"};
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(StatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stat, container, false);
        balance_m2 = (TextView) root.findViewById(R.id.balance_m2);
        pieChart = (PieChart) root.findViewById(R.id.pie_chart);
        barchart=(BarChart)root.findViewById(R.id.bar_chart);

        dbManager = new DbManager(getActivity());
        dbManager.openDb();
        balance_m2.setText(String.valueOf(dbManager.getFromDbAllSum()) + " Р");
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawEntryLabels(false);
        Legend l = pieChart.getLegend();
        l.setOrientation(Legend.LegendOrientation.VERTICAL);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        l.setTextSize(14);
        XAxis xAxis = barchart.getXAxis();
        xAxis.setEnabled(false);
        barchart.getAxisRight().setDrawLabels(false);
        barchart.getAxisLeft().setDrawLabels(false);
        barchart.getDescription().setEnabled(false);
        Legend n = barchart.getLegend();
        n.setTextSize(14);
        n.setVerticalAlignment(Legend.LegendVerticalAlignment.CENTER);
        n.setOrientation(Legend.LegendOrientation.VERTICAL);
        setDataPieChart();
        setDataBarChart();
        return root;
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

    public void setDataPieChart(){
        ArrayList<PieEntry> yValues = new ArrayList<>();
        yValues.add(new PieEntry(dbManager.getFromDbSumFood(),"Еда"));
        yValues.add(new PieEntry(dbManager.getFromDbSumShopping(),"Шоппинг"));
        yValues.add(new PieEntry(dbManager.getFromDbSumProducts(),"Продукты"));
        yValues.add(new PieEntry(dbManager.getFromDbSumTransport(),"Транспорт"));
        yValues.add(new PieEntry(dbManager.getFromDbSumEntertainments(),"Развлечения"));
        yValues.add(new PieEntry(dbManager.getFromDbSumHealth(),"Здоровье"));
        yValues.add(new PieEntry(dbManager.getFromDbSumHousing(),"Жилье"));
        yValues.add(new PieEntry(dbManager.getFromDbSumFin_expenses(),"Фин расходы"));
        yValues.add(new PieEntry(dbManager.getFromDbSumOther_ras(),"Другое Расходы"));
        yValues.add(new PieEntry(dbManager.getFromDbSumSalary(),"Зарплата"));
        yValues.add(new PieEntry(dbManager.getFromDbSumInvest(),"Инвестиции"));
        yValues.add(new PieEntry(dbManager.getFromDbSumOther_dox(),"Другое Доходы"));
        PieDataSet set1 = new PieDataSet(yValues,"");
        set1.setColors(colors);
        PieData data= new PieData(set1);
        data.setValueTextSize(12);
        data.setValueTextColor(Color.WHITE);
        pieChart.setData(data);
    }

    public void setDataBarChart(){
        ArrayList<BarEntry> yValues = new ArrayList<>();
        yValues.add(new BarEntry(1,dbManager.getFromDbSumRasxod()));
        yValues.add(new BarEntry(2.5f,dbManager.getFromDbSumDoxod()));
        BarDataSet set1 = new BarDataSet(yValues,"Расходы Доходы");
        set1.setColors(colors1);
        BarData data = new BarData(set1);
        data.setValueTextSize(13);
        barchart.setData(data);
    }
}