package com.example.newex;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.newex.HotelDB.User;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

public class Lk extends AppCompatActivity {

   private EditText input_name, input_email,input_sname, input_fname, input_birthday, input_phone;
       private String name, email, sname, fname, birthday, phone;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lk);

       User user = (User) getIntent().getSerializableExtra("User");
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");


        input_name = (EditText) findViewById(R.id.Name_reg);
        input_email = (EditText) findViewById(R.id.Email_reg);
        input_birthday= (EditText) findViewById(R.id.Birthday_reg);
        input_fname=(EditText) findViewById(R.id.Fname_reg);
        input_sname=(EditText) findViewById(R.id.Sname_reg);
        input_fname=(EditText) findViewById(R.id.Fname_reg);
        input_phone=(EditText) findViewById(R.id.Phone_reg);
        Button update= findViewById(R.id.updatebtn);

       /*input_name.setText(user.getName());
        input_phone.setText(user.getPhone());
        input_fname.setText(user.getFname());
        input_sname.setText(user.getSname());
        input_birthday.setText(user.getBirthday());
        input_email.setText(user.getEmail());
            */
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = input_name.getText().toString();
                sname = input_sname.getText().toString();
                fname = input_fname.getText().toString();
                phone = input_phone.getText().toString();
                birthday = input_birthday.getText().toString();
                email = input_email.getText().toString();

                // validating the text fields if empty or not.
                if (TextUtils.isEmpty(sname)) {
                    input_sname.setError("Please enter  SName");
                } else if (TextUtils.isEmpty(name)) {
                    input_name.setError("Please enter Name ");
                } else if (TextUtils.isEmpty(fname)) {
                    input_fname.setError("Please enter Fname ");
                }else if (TextUtils.isEmpty(phone)) {
                    input_phone.setError("Please enter Phone ");
                } else if (TextUtils.isEmpty(birthday)) {
                    input_birthday.setError("Please enter Birthday ");
                }else if (TextUtils.isEmpty(email)) {
                    input_email.setError("Please enter Email");
                }
                else {
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Sname").setValue(sname);
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Name").setValue(name);
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Fname").setValue(fname);
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Phone").setValue(phone);
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Birthday").setValue(birthday);
                    databaseReference.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("Email").setValue(email);

                    Toast.makeText(Lk.this, "Profile Updated",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Lk.this , profile.class));
                    finish();
                    // calling a method to update our course.
                    // we are passing our object class, course name,
                    // course description and course duration from our edittext field.

                  //  updateCourses(user,name,sname, fname, birthday, phone, email);
                }
            }
        });
    }

 /*   public void changeSave(View view) {
        name = input_name.getText().toString();
        sname = input_sname.getText().toString();
        fname = input_fname.getText().toString();
        phone = input_phone.getText().toString();
        birthday = input_birthday.getText().toString();
        email = input_email.getText().toString();

        // validating the text fields if empty or not.
        if (TextUtils.isEmpty(name)) {
            input_name.setError("Please enter  Name");
        } else if (TextUtils.isEmpty(sname)) {
            input_sname.setError("Please enter Sname ");
        } else if (TextUtils.isEmpty(fname)) {
            input_fname.setError("Please enter Fname ");
        }else if (TextUtils.isEmpty(phone)) {
            input_phone.setError("Please enter Phone ");
        } else if (TextUtils.isEmpty(birthday)) {
            input_birthday.setError("Please enter Birthday ");
        }else if (TextUtils.isEmpty(email)) {
            input_email.setError("Please enter Email");
        }
        else {
            // calling a method to update our course.
            // we are passing our object class, course name,
            // course description and course duration from our edittext field.

            updateCourses(user,name,sname, fname, birthday, phone, email);
        }
    }*/

  /* private void updateCourses(User user, String name, String sname, String fname, String birthday, String phone, String email) {
        // inside this method we are passing our updated values
        // inside our object class and later on we
        // will pass our whole object to firebase Firestore.
        User updatedCourse = new User(name, sname, fname, birthday,phone,email);

        // after passing data to object class we are
        // sending it to firebase with specific document id.
        // below line is use to get the collection of our Firebase Firestore.
        db.collection("User").
                // below line is use toset the id of
                // document where we have to perform
                // update operation.
                        document(user.getId()).

                // after setting our document id we are
                // passing our whole object class to it.
                        set(updatedCourse).

                // after passing our object class we are
                // calling a method for on success listener.
                        addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        // on successful completion of this process
                        // we are displaying the toast message.
                        Toast.makeText(Lk.this, "Course has been updated..", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
            // inside on failure method we are
            // displaying a failure message.
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(Lk.this, "Fail to update the data..", Toast.LENGTH_SHORT).show();
            }
        });
    }*/



}
