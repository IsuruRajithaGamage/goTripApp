 package com.isurucreation.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class Hotel_Page_List extends AppCompatActivity {
    //widgets
    Button addPost;
    RecyclerView recyclerView;
    private DatabaseReference databaseReference;
    private StorageReference storageReference;
    private ArrayList<downloadinfo> downlaodinfoList;
    private RecyclerAdapter recyclerAdapter;

    private Context mContext;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel__page__list);


        recyclerView= findViewById(R.id.recyclerView);
        addPost = (Button)findViewById(R.id.addPost);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        //fireBase
        databaseReference = FirebaseDatabase.getInstance().getReference();
        storageReference = FirebaseStorage.getInstance().getReference();

        //ArrayList
        downlaodinfoList = new ArrayList<>();

        //Clear ArrayList
        ClearAll();

        //getData Method
        GetDataFromFirebase();

        addPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);


            }
        });

            }

            private void GetDataFromFirebase(){
                Query query = databaseReference.child("OnLisT");
                query.addValueEventListener(new ValueEventListener() {

                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        ClearAll();
                      for(DataSnapshot snapshot : dataSnapshot.getChildren()){
                          downloadinfo Downloadinfo = new downloadinfo();
                          Downloadinfo.setHotelName(snapshot.child("HotelName").getValue().toString());
                          Downloadinfo.setImageURL(snapshot.child("imageURL").getValue().toString());
                          Downloadinfo.setAddressHotel(snapshot.child("AddressHotel").getValue().toString());
                          Downloadinfo.setTelephoneHotel(snapshot.child("telephoneHotel").getValue().toString());
                          downlaodinfoList.add(Downloadinfo);
                      }
                        recyclerAdapter = new RecyclerAdapter(getApplicationContext(),downlaodinfoList);
                        recyclerView.setAdapter(recyclerAdapter);
                        recyclerAdapter.notifyDataSetChanged();

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }

    private void ClearAll(){
        if(downlaodinfoList !=null){
            downlaodinfoList.clear();

            if(recyclerAdapter != null){
                recyclerAdapter.notifyDataSetChanged();
            }

        }
        downlaodinfoList =new ArrayList<>();
    }




    }
