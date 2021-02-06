package com.isurucreation.myapplication;

import android.os.Parcel;
import android.os.Parcelable;

public class downloadinfo implements Parcelable {


    String HotelName;
    String imageURL;
    String AddressHotel;
    String telephoneHotel;

    public downloadinfo(){

    }


   public downloadinfo(String HotelName,String imageURL,String AddressHotel,String telephoneHotel){

        this.HotelName=HotelName;
        this.imageURL=imageURL;
        this.AddressHotel=AddressHotel;
        this.telephoneHotel=telephoneHotel;

   }

    protected downloadinfo(Parcel in) {
        HotelName = in.readString();
        imageURL = in.readString();
        AddressHotel = in.readString();
        telephoneHotel = in.readString();
    }

    public static final Creator<downloadinfo> CREATOR = new Creator<downloadinfo>() {
        @Override
        public downloadinfo createFromParcel(Parcel in) {
            return new downloadinfo(in);
        }

        @Override
        public downloadinfo[] newArray(int size) {
            return new downloadinfo[size];
        }
    };

    public String getHotelName() {
        return HotelName;
    }

    public String getAddressHotel() {
        return AddressHotel;
    }

    public void setAddressHotel(String addressHotel) {
        AddressHotel = addressHotel;
    }

    public String getTelephoneHotel() {
        return telephoneHotel;
    }

    public void setTelephoneHotel(String telephoneHotel) {
        this.telephoneHotel = telephoneHotel;
    }

    public String getImageURL() {
        return imageURL;


    }

    public void setHotelName(String hotelName) {
        HotelName = hotelName;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(HotelName);
        parcel.writeString(imageURL);
        parcel.writeString(AddressHotel);
        parcel.writeString(telephoneHotel);
    }
}




