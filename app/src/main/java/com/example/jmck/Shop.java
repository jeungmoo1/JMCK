package com.example.jmck;

public class Shop {
    String name;
    String address;
    String phoneNumber;
    double stars;
    double latitude;
    double longitude;
    int imageRes;

    public Shop(String name, String address, String phoneNumber, double stars, double latitude, double longitude, int imageRes) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.stars = stars;
        this.latitude = latitude;
        this.longitude = longitude;
        this.imageRes = imageRes;
    }
}
