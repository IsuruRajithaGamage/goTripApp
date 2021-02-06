package com.isurucreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class HotelDetails extends AppCompatActivity {

    public static final String EXTRA_HOTEL_DETAILS="extra_hotel_details";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);


        ImageView imageView = findViewById(R.id.imageView1);
        TextView textView= findViewById(R.id.textView2);
        TextView address= findViewById(R.id.addresstext);
        TextView phone=findViewById(R.id.phoneh);


        downloadinfo ddd = getIntent().getParcelableExtra(EXTRA_HOTEL_DETAILS);
        textView.setText(ddd.getHotelName());
        Glide.with(this).load(ddd.getImageURL()).into(imageView);
        address.setText(ddd.getAddressHotel());
        phone.setText(ddd.getTelephoneHotel());

    



    }




}