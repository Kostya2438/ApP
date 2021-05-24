package com.example.app2.ui.statistic;

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
import com.github.mikephil.charting.charts.PieChart;

public class StatFragment extends Fragment {

    private StatViewModel galleryViewModel;
    TextView balance_m2, money_food, money_shopping, money_products, money_transport, money_entertainments, money_health, money_housing, money_fin_expenses,
            money_other_ras, money_salary, money_invest, money_other_dox;
    private DbManager dbManager;
    PieChart pieChart;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(StatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_stat, container, false);
        balance_m2 = (TextView) root.findViewById(R.id.balance_m2);
        money_food = (TextView) root.findViewById(R.id.money_food);
        money_shopping = (TextView) root.findViewById(R.id.money_shopping);
        money_products = (TextView) root.findViewById(R.id.money_products);
        money_transport = (TextView) root.findViewById(R.id.money_transport);
        money_entertainments = (TextView) root.findViewById(R.id.money_entertainments);
        money_health = (TextView) root.findViewById(R.id.money_health);
        money_housing = (TextView) root.findViewById(R.id.money_housing);
        money_fin_expenses = (TextView) root.findViewById(R.id.money_fin_expenses);
        money_other_ras = (TextView) root.findViewById(R.id.money_other_ras);
        money_salary = (TextView) root.findViewById(R.id.money_salary);
        money_invest = (TextView) root.findViewById(R.id.money_investment);
        money_other_dox = (TextView) root.findViewById(R.id.money_other_dox);
        pieChart = (PieChart) root.findViewById(R.id.pie_chart);

        dbManager = new DbManager(getActivity());
        dbManager.openDb();
        balance_m2.setText(String.valueOf(dbManager.getFromDbAllSum()) + " Р");
        money_food.setText(String.valueOf(dbManager.getFromDbSumFood()) + " Р");
        money_shopping.setText(String.valueOf(dbManager.getFromDbSumShopping()) + " Р");
        money_products.setText(String.valueOf(dbManager.getFromDbSumProducts()) + " Р");
        money_transport.setText(String.valueOf(dbManager.getFromDbSumTransport()) + " Р");
        money_entertainments.setText(String.valueOf(dbManager.getFromDbSumEntertainments()) + " Р");
        money_health.setText(String.valueOf(dbManager.getFromDbSumHealth()) + " Р");
        money_housing.setText(String.valueOf(dbManager.getFromDbSumHousing()) + " Р");
        money_fin_expenses.setText(String.valueOf(dbManager.getFromDbSumFin_expenses()) + " Р");
        money_other_ras.setText(String.valueOf(dbManager.getFromDbSumOther_ras()) + " Р");
        money_salary.setText(String.valueOf(dbManager.getFromDbSumSalary()) + " Р");
        money_invest.setText(String.valueOf(dbManager.getFromDbSumInvest()) + " Р");
        money_other_dox.setText(String.valueOf(dbManager.getFromDbSumOther_dox()) + " Р");
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
}