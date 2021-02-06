package com.isurucreation.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class tripPlaces extends AppCompatActivity {

    private ArrayList<downalodplaces>placeslist;

    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private AdapterForPlaces adapterForPlaces;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_places);


        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        databaseReference = FirebaseDatabase.getInstance().getReference();


        GetDataFromFirebase();

        placeslist = new ArrayList<>();

        ClearAll();





    }
    private void GetDataFromFirebase(){

        Query query = databaseReference.child("Places");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                ClearAll();
                for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                    downalodplaces Downalodplaces = new downalodplaces();

                    Downalodplaces.setImgURL(snapshot.child("imgURL").getValue().toString());
                    Downalodplaces.setNameOFplace(snapshot.child("nameOFplace").getValue().toString());
                    Downalodplaces.setDescription(snapshot.child("description").getValue().toString());
                    Downalodplaces.setPlace(snapshot.child("place").getValue().toString());


                  //  Intent intent= new Intent(mContext,DetailsPlace.class);
                   // intent.putExtra("ADO",des);
                    //startActivity(intent);

                    placeslist.add(Downalodplaces);
                }

               adapterForPlaces = new AdapterForPlaces(getApplicationContext(),placeslist);
                recyclerView.setAdapter(adapterForPlaces);
                adapterForPlaces.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }


    private void ClearAll(){
        if(placeslist !=null){
            placeslist.clear();

            if(adapterForPlaces != null){
                adapterForPlaces.notifyDataSetChanged();
            }

        }
        placeslist =new ArrayList<>();
    }

}