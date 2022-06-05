package com.example.newex;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final  EditText login= findViewById(R.id.login);
        final  EditText password = findViewById(R.id.passwordLogin);
        final Button auth=findViewById(R.id.enter);
        auth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String loginText= login.getText().toString();
                final  String passwordText= password.getText().toString();
                if (loginText.isEmpty()|| passwordText.isEmpty())
                {
                    Toast toast= Toast.makeText(MainActivity.this, "Ошибка! Заполните пустые поля", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this,"Добро пожаловать!", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(MainActivity.this,GlavnMenu.class);
                    startActivity(intent);
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        openQuitDialog();
    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                MainActivity.this);
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


    public void btn_reg(View view) {
        Intent intent = new Intent(MainActivity.this,reg.class);
        startActivity(intent);
    }


}