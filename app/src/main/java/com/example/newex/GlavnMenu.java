package com.example.newex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newex.Adapter.recentsAdapter;
import com.example.newex.Adapter.serviceAdapter;
import com.example.newex.Model.recentsData;
import com.example.newex.Model.serviceData;

import java.util.ArrayList;
import java.util.List;

public class GlavnMenu extends AppCompatActivity {
    RecyclerView recentRecycler, serviceRecycler;
    com.example.newex.Adapter.recentsAdapter recentsAdapter;
    com.example.newex.Adapter.serviceAdapter serviceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.glavn_menu);
       List<recentsData> recentsDataList = new ArrayList<>();
        recentsDataList.add(new recentsData("Одноместный номер", R.drawable.hotel1));
        recentsDataList.add(new recentsData("Двухместный номер", R.drawable.hotel2));
        recentsDataList.add(new recentsData("Комплекс на 5 ночей", R.drawable.hotel3));

        setRecentRecycler(recentsDataList);


    List<serviceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(new serviceData("СПА комплекс", R.drawable.service2));
        serviceDataList.add(new serviceData("Фитнесс зал", R.drawable.service1));
        serviceDataList.add(new serviceData("Библиотека", R.drawable.service3));

        setServiceRecycler(serviceDataList);


    }

    private  void setRecentRecycler(List<recentsData> recentsDataList){

        recentRecycler = findViewById(R.id.recents_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new recentsAdapter(this, recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);

    }
    private  void setServiceRecycler(List<serviceData> serviceDataList){

        serviceRecycler = findViewById(R.id.service_recycle);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        serviceRecycler.setLayoutManager(layoutManager);
        serviceAdapter = new serviceAdapter(this, serviceDataList);
        serviceRecycler.setAdapter(serviceAdapter);

    }
    public void moreRooms_btn(View view){
        Intent intent= new Intent(GlavnMenu.this,roomdetails.class);
        startActivity(intent);
    }
    public void btn_menu(View view){
        Intent intent= new Intent(GlavnMenu.this,profile.class);
        startActivity(intent);
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                GlavnMenu.this);
        quitDialog.setTitle("Выход: Вы уверены?");

        quitDialog.setPositiveButton("ДА", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        quitDialog.setNegativeButton("НЕТ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // TODO Auto-generated method stub
            }
        });

        quitDialog.show();
    }

}
