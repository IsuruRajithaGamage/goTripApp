package com.isurucreation.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterForPlaces extends RecyclerView.Adapter<AdapterForPlaces.ViewHolder> {

    private static final String Tag= "RecyclerView";
    private Context mContext;
    private ArrayList<downalodplaces>placeslist;

    public AdapterForPlaces(ArrayList<downalodplaces>placeslist){
        this.placeslist = placeslist;
    }
    public AdapterForPlaces(Context mContext){
        this.mContext= mContext;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

         View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listofplaces,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //TextView
        holder.textView.setText(placeslist.get(position).getNameOFplace());
        //holder.textViewDes.setText(placeslist.get(position).getDescription());

       // holder.textViewAddress.setText(placeslist.get(position).getAddress());
        //ImageView
        Glide.with(mContext).load(placeslist.get(position).getImgURL())
                .into(holder.imageView);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext,DetailsPlace.class);
                intent.putExtra(DetailsPlace.EXTRA_PLACE_DETAILS,placeslist.get(position));
                view.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return placeslist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView,textViewDes,textViewAddress;
        public ViewHolder(View itemView){
            super(itemView);

            imageView = itemView.findViewById(R.id.imageView);
            textView= itemView.findViewById(R.id.textView);
          //  textViewAddress=itemView.findViewById(R.id.textViewAddress);
         //   textViewDes=itemView.findViewById(R.id.textViewDes);




        }
    }
    public  AdapterForPlaces(Context mContext,ArrayList<downalodplaces>placeslist){
        this.mContext=mContext;
        this.placeslist=placeslist;

    }
}
