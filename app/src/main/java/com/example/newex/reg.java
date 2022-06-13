package com.example.newex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newex.HotelDB.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class reg extends AppCompatActivity {

    private FirebaseAuth.AuthStateListener mAuthListener;
    FirebaseDatabase database;
    DatabaseReference UserDataBase;


    FirebaseAuth firebaseAuth;
    private EditText textsnameReg;
    private EditText textfnameReg;
    private EditText textNameReg;
    private EditText textPasswordReg2;
    private EditText textEmailReg;
    private EditText textPasswordReg;
    private EditText textphoneReg;
    private EditText textbirthdayReg;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.reg);
        super.onCreate(savedInstanceState);
            Init();
       /* mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                } else {
                    // User is signed out
                }

            }
        };*/

        //Если уже есть авторизованный пользователь, то переходим на главное окно
      /*  FirebaseUser user = mAuth.getCurrentUser();
        if (user != null)
        {
            Intent auth = new Intent(reg.this, MainFrameActivity.class);
            startActivity(auth);
            finish();
        }*/



    }


    private void Init()
    {
        //Находим лайауты авторизации и регистрации, чтобы меняться между ними


      //  mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        UserDataBase = database.getReference("Users");
        firebaseAuth = FirebaseAuth.getInstance();

        textsnameReg = findViewById(R.id.Sname_reg);
        textfnameReg = findViewById(R.id.Fname_reg);
        textphoneReg = findViewById(R.id.Phone_reg);
        textbirthdayReg = findViewById(R.id.Birthday_reg);
        textEmailReg = findViewById(R.id.Email_reg);
        textPasswordReg = findViewById(R.id.Password);
        textNameReg = findViewById(R.id.Name_reg);
        textPasswordReg2 = findViewById(R.id.rePassword);

    }





    public void registration_btn(View view)
        {
            final  String EmailReg = textEmailReg.getText().toString();
            String PasswordReg = textPasswordReg.getText().toString();
            String PasswordReg2 = textPasswordReg2.getText().toString();
            final  String NickName = textNameReg.getText().toString();
            final  String PhoneReg = textphoneReg.getText().toString();
            final  String BirthdayReg = textbirthdayReg.getText().toString();
            final  String SnameReg = textsnameReg.getText().toString();
            final  String FnameReg = textfnameReg.getText().toString();

            if(EmailReg.isEmpty()) {

                Toast.makeText(reg  .this,
                        "Поле 'Email' не может быть пустым!", Toast.LENGTH_LONG).show();

            }
            else if (PasswordReg.isEmpty()) {
                Toast.makeText(reg.this,
                        "Поле 'Пароль' не может быть пустым!", Toast.LENGTH_LONG).show();

            } else if (NickName.isEmpty()) {
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();

            } else if (!(PasswordReg.equals(PasswordReg2))) {
                Toast.makeText(reg.this,
                        "Пароли не совпадают!", Toast.LENGTH_LONG).show();

            }

            firebaseAuth.createUserWithEmailAndPassword(EmailReg, PasswordReg)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                User info = new User(UserDataBase.getKey(), NickName, SnameReg, FnameReg, BirthdayReg, PasswordReg, EmailReg, PhoneReg);
                                FirebaseDatabase.getInstance().getReference("Users").child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(info).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(reg.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                                        finish();
                                    }
                                });

                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(reg.this, "Error!", Toast.LENGTH_SHORT).show();
                            }

                    }
                });

          /* if(EmailReg.isEmpty()) {
 User newUser = new User(UserDataBase.getKey(), NickName, SnameReg, FnameReg, BirthdayReg, PasswordReg, EmailReg, PhoneReg);
                Toast.makeText(reg.this,
                        "Поле 'Email' не может быть пустым!", Toast.LENGTH_LONG).show();

            }
            else if (PasswordReg.isEmpty()) {
                Toast.makeText(reg.this,
                        "Поле 'Пароль' не может быть пустым!", Toast.LENGTH_LONG).show();

            }else if(SnameReg.isEmpty()){
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();
                }
            else if (FnameReg.isEmpty()){
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();
            }
            else if (PhoneReg.isEmpty()){
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();
            }
            else if (BirthdayReg.isEmpty()){
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();
            }
            else if (NickName.isEmpty()) {
                Toast.makeText(reg.this,
                        "Поле 'Имя пользователя' не может быть пустым!", Toast.LENGTH_LONG).show();

            } else if (!PasswordReg.equals(PasswordReg2)) {
                Toast.makeText(reg.this,
                        "Пароли не совпадают!", Toast.LENGTH_LONG).show();

            } else {
                mAuth.createUserWithEmailAndPassword(EmailReg, PasswordReg).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            Toast.makeText(reg.this,
                                    "Регистрация провалена!", Toast.LENGTH_LONG).show();
                        }else {
                            Toast.makeText(reg.this,
                                    "Регистрация успешна!", Toast.LENGTH_LONG).show();

                            mAuth.signInWithEmailAndPassword(EmailReg, PasswordReg).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        if(user != null)
                                        {
                                            User newUser = new User( UserDataBase.getKey(), NickName, SnameReg,FnameReg, BirthdayReg, PasswordReg,user.getUid() ,EmailReg, PhoneReg);
                                            UserDataBase.push().setValue(newUser).addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if(task.isSuccessful())
                                                    {
                                                        //Переход на новое окно при успешной регистрации
                                                        Intent intent_reg = new Intent(reg.this,MainActivity.class);
                                                        startActivity(intent_reg);
                                                        finish();
                                                    }
                                                }
                                            });

                                        }
                                    }
                                }
                            });

                        }
                    }
                });*/
            }

           /* if (Name.isEmpty() || Email.isEmpty() || Password.isEmpty() || repassword.isEmpty() || repassword.isEmpty())
            {
                Toast toast = Toast.makeText(reg.this, "Ошибка! Заполните пустые поля", Toast.LENGTH_SHORT);
                toast.show();
            }
            else
            {
                Toast toast = Toast.makeText(reg.this, "Регистрация прошла успешно", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(reg.this, MainActivity.class);
                startActivity(intent);
            }*/


        }



