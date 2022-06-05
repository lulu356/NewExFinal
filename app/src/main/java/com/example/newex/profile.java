package com.example.newex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.profile);
        super.onCreate(savedInstanceState);
    }
    public void LK_btn(View view){
        Intent intent= new Intent(profile.this,Lk.class);
        startActivity(intent);
    }
    public void info_btn(View view){
        Intent intent= new Intent(profile.this,info.class);
        startActivity(intent);
    }
    public void booking_btn(View view){
        Intent intent= new Intent(profile.this,booking.class);
        startActivity(intent);
    }
    public void back_btn(View view){
        Intent intent= new Intent(profile.this,GlavnMenu.class);
        startActivity(intent);
    }


    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                profile.this);
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
