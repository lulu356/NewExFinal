package com.example.newex;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.example.newex.HotelDB.User;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;

public class profile extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;

    // creating a variable for our
    // Database Reference for Firebase.
    DatabaseReference databaseReference;

    // variable for Text view.
    private TextView retrieveTV;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.profile);
        super.onCreate(savedInstanceState);

        firebaseDatabase = FirebaseDatabase.getInstance();
       // databaseReference=FirebaseDatabase.getInstance().getReference().child("users").child(user_id);
        // below line is used to get
        // reference for our database.
       // databaseReference = firebaseDatabase.getReference("User");

        // initializing our object class variable.
        retrieveTV = findViewById(R.id.userName);

        // calling method
        // for getting data.


        String uname = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        retrieveTV.setText("Logged in as " + uname);

    }



  /* private void getdata() {

        // calling add value event listener method
        // for getting the values from database.
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // calling on cancelled method when we receive
                // any error or we are not able to get the data.
                Toast.makeText(profile.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    //

    public void LK_btn(View view) {
        Intent intent = new Intent(profile.this, Lk.class);
        startActivity(intent);
    }

    public void info_btn(View view) {
        Intent intent = new Intent(profile.this, info.class);
        startActivity(intent);
    }

    public void booking_btn(View view) {
        Intent intent = new Intent(profile.this, booking.class);
        startActivity(intent);
    }

    public void back_btn(View view) {
        Intent intent = new Intent(profile.this, GlavnMenu.class);
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


