package com.example.app2.ui.bill;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import com.example.app2.Data.DbManager;
import com.example.app2.MAINMENU;
import com.example.app2.R;

import java.util.Map;

public class BillFragment extends Fragment {

    private BillViewModel slideshowViewModel;
    DbManager dbManager;
    RelativeLayout layout;
    int margin=1;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(BillViewModel.class);
        View root = inflater.inflate(R.layout.fragment_bill, container, false);
        layout=(RelativeLayout) root.findViewById(R.id.layout_operations);

        dbManager = new DbManager(getActivity());
        dbManager.openDb();

        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsFood().entrySet()){
            layout.addView(createTextCat("Еда",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,250));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,420,enty.getKey(),enty.getValue(),1));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsShopping().entrySet()){
            layout.addView(createTextCat("Шоппинг",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,280));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,450,enty.getKey(),enty.getValue(),1));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsProducts().entrySet()){
            layout.addView(createTextCat("Продукты",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,310));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,480,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsTransport().entrySet()){
            layout.addView(createTextCat("Транспорт",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,310));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,480,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsEnter().entrySet()){
            layout.addView(createTextCat("Развлечения",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,370));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,540,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsHealth().entrySet()){
            layout.addView(createTextCat("Здоровье",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,290));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,460,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsHousing().entrySet()){
            layout.addView(createTextCat("Жилье",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,255));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,425,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsFin_ex().entrySet()){
            layout.addView(createTextCat("Фин расходы",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,380));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,550,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsOther_ras().entrySet()){
            layout.addView(createTextCat("Другое Расходы",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,450));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,620,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsSalary().entrySet()){
            layout.addView(createTextCat("Зарплата",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,290));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,460,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsInvest().entrySet()){
            layout.addView(createTextCat("Инвестиции",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,360));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,530,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
        for (Map.Entry<Integer,Integer> enty: dbManager.getFromDbOperationsOther_dox().entrySet()){
            layout.addView(createTextCat("Другое Доход",RelativeLayout.ALIGN_LEFT,28*margin));
            layout.addView(createTextSum(enty.getValue(),RelativeLayout.ALIGN_LEFT,28*margin,430));
            layout.addView(createButton(RelativeLayout.ALIGN_LEFT,28*margin,600,enty.getKey(),enty.getValue(),0));
            margin+=4;
        }
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

    TextView createTextSum(int text,int align,int margin,int margin_l){
        TextView operat = new TextView(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(margin_l,margin,0,0);
        params.addRule(align);
        operat.setLayoutParams(params);
        operat.setText(String.valueOf(text)+" Р");
        operat.setTextSize(18);
        operat.setTypeface(ResourcesCompat.getFont(getActivity(),R.font.amiko_bold));
        operat.setTextColor(Color.BLACK);
        operat.setGravity(Gravity.CENTER);
        operat.setPadding(20,20,20,20);
        return operat;
    }

    TextView createTextCat(String text, int align,int margin){
        TextView operat = new TextView(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(50,margin,0,0);
        params.addRule(align);
        operat.setLayoutParams(params);
        operat.setText(text);
        operat.setTypeface(ResourcesCompat.getFont(getActivity(),R.font.amiko_bold));
        operat.setTextSize(18);
        operat.setTextColor(Color.BLACK);
        operat.setGravity(Gravity.CENTER);
        operat.setPadding(20,20,20,20);
        return operat;
    }
    Button createButton(int align, int margin,int margin_le, final int id, final int summ, final int rd){
        final Button but = new Button(getActivity());
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(70,70);
        params.setMargins(margin_le,margin+15,0,0);
        params.addRule(align);
        but.setLayoutParams(params);
        but.setBackground(getResources().getDrawable(R.drawable.delete_cat));
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    dbManager.deleteFromDb(id);
                    dbManager.insectToDbOther(rd,summ);
                    Intent intent = new Intent(BillFragment.this.getActivity(), MAINMENU.class);
                    startActivity(intent);
            }
        });
        return but;
    }
}