package com.isurucreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.google.firebase.auth.FirebaseAuth;

public class welcomeScreen extends AppCompatActivity {

    ImageButton btnplaces,btnHotels;
    ImageView newimge;
    Button btnLogout;
    FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListner;



    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        btnHotels = (ImageButton) findViewById(R.id.btnHotels);
        btnplaces = (ImageButton) findViewById(R.id.btnplaces);
        btnLogout = findViewById(R.id.logout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Intent mai= new Intent(welcomeScreen.this, LoginUser.class);
                startActivity(mai);
            }
        });


    }

    public void listOfPLaces(View view) {
        Intent intent = new Intent(getApplicationContext(),tripPlaces.class);
        startActivity(intent);
    }

    public void HotelList(View view) {
        Intent intent = new Intent(getApplicationContext(),Hotel_Page_List.class);
        startActivity(intent);
    }
}