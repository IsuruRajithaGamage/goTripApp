package com.isurucreation.myapplication;

public class uploadinfo {

    public String imageName;
    public String imageURL;
    private String HotelAddress;
    private String HotelTelePhne;



    public uploadinfo(){}

    public uploadinfo(String name, String url) {
        this.imageName = name;
        this.imageURL = url;
    }

    public String getImageName() {
        return imageName;
    }
    public String getImageURL() {
        return imageURL;
    }

    public String getHotelAddress(){
        return HotelAddress;
    }

    public void setHotelAddress(String haddress){
        HotelAddress =haddress;
    }
    public String getHotelTelePhne(){
        return HotelTelePhne;
    }
    public void setHotelTelePhne(String tele){
        HotelTelePhne = tele;
    }

}
