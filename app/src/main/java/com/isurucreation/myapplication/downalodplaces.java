package com.isurucreation.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class downalodplaces implements Parcelable {
    String imgURL;
    String nameOFplace;
     String description;
    String place;
    



    public downalodplaces(){

    }
    public downalodplaces(String imgURL, String nameOFplace,String description ,String place){
        this.imgURL=imgURL;
        this.nameOFplace=nameOFplace;
       this.description=description;
       this.place=place;
    }



    protected downalodplaces(Parcel in) {
        imgURL = in.readString();
        nameOFplace = in.readString();
        description = in.readString();
        place=in.readString();

    }

    public static final Creator<downalodplaces> CREATOR = new Creator<downalodplaces>() {
        @Override
        public downalodplaces createFromParcel(Parcel in) {
            return new downalodplaces(in);
        }

        @Override
        public downalodplaces[] newArray(int size) {
            return new downalodplaces[size];
        }
    };

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getNameOFplace() {
        return nameOFplace;
    }

    public void setNameOFplace(String nameOFplace) {
        this.nameOFplace = nameOFplace;
    }


    public String getDescription() {
       return description;
    }

    public void setDescription(String description) {
        this.description = description;
   }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(imgURL);
        parcel.writeString(nameOFplace);
        parcel.writeString(description);
        parcel.writeString(place);

    }
}
