package com.isurucreation.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailsPlace extends AppCompatActivity {

    public static final String EXTRA_PLACE_DETAILS="extra_place_details";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_place);


        TextView textView = findViewById(R.id.textViewP);
        ImageView imageView= findViewById(R.id.imageViewP);
        TextView plaz= findViewById(R.id.txtplace);
        TextView textView2 = findViewById(R.id.textViewDes);


        downalodplaces ppp = getIntent().getParcelableExtra(EXTRA_PLACE_DETAILS);

        Glide.with(this).load(ppp.getImgURL()).into(imageView);
        textView.setText(ppp.getNameOFplace());
         textView2.setText(ppp.getDescription());
        plaz.setText(ppp.getPlace());

       // textView1.setText(ppp.getAddress());
      // textView2.setText(ppp.getDescription());





    }
}