package com.isurucreation.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.io.Serializable;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private static final String Tag = "RecyclerView";
    private Context mContext;
    private ArrayList<downloadinfo> downloadinfoList;


    public RecyclerAdapter(ArrayList<downloadinfo> downloadinfoList) {
        this.downloadinfoList = downloadinfoList;
    }

    public RecyclerAdapter(Context mContext) {
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemsview, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder holder, int position) {

        //TextView
        holder.textView.setText(downloadinfoList.get(position).getHotelName());

        //ImageView
        Glide.with(mContext).load(downloadinfoList.get(position).getImageURL())
                .into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,HotelDetails.class);
                intent.putExtra(HotelDetails.EXTRA_HOTEL_DETAILS,downloadinfoList.get(position));
                view.getContext().startActivity(intent);

            }
        });




        
    }

    @Override
    public int getItemCount() {
        return downloadinfoList.size();

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //widgets
        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);


        }
    }

    public RecyclerAdapter(Context mContext, ArrayList<downloadinfo> downloadinfoList) {
        this.mContext = mContext;
        this.downloadinfoList = downloadinfoList;
    }
}