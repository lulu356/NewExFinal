package com.example.newex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database;
    DatabaseReference UserDataBase;

    private EditText textEmail;
    private EditText textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");
          Init();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                } else {
                    // User is signed out
                }

            }
        };

        //Если уже есть авторизованный пользователь, то переходим на главное окно
      /*  FirebaseUser user = mAuth.getCurrentUser();
        if (user != null)
        {
            Intent auth = new Intent(MainActivity.this, GlavnMenu.class);
            startActivity(auth);
            finish();
        }*/

    }


    private void Init()
    {
        //Находим лайауты авторизации и регистрации, чтобы меняться между ними


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        UserDataBase = database.getReference(Constants.USER_KEY);

        textEmail = findViewById(R.id.login);
        textPassword = findViewById(R.id.passwordLogin);



    }

    public  void enter(View view){
        String Email = textEmail.getText().toString();
        String Password = textPassword.getText().toString();

        if(Email.isEmpty()) {

            Toast.makeText(MainActivity.this,
                    "Поле 'Email' не может быть пустым!", Toast.LENGTH_LONG).show();

        }
        else if (Password.isEmpty()) {
            Toast.makeText(MainActivity.this,
                    "Поле 'Пароль' не может быть пустым!", Toast.LENGTH_LONG).show();
        } else {
            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!task.isSuccessful()) {
                        Toast.makeText(MainActivity.this,
                                "Email или пароль введены неверно!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this,
                                "Авторизация успешна!", Toast.LENGTH_LONG).show();


                        //Переход на новое окно при успешной авторизации
                        Intent intent = new Intent(MainActivity.this,GlavnMenu.class);
                        startActivity(intent);
                    }
                }
            });
        }
    }

    public void btn_reg(View view) {
        Intent intent = new Intent(MainActivity.this, reg.class);
        startActivity(intent);
    }




}
