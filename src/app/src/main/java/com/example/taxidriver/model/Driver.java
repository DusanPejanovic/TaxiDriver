package com.example.taxidriver.model;

public class Driver extends User{

    String driving_license;
    String traffic_license;
    boolean is_active;

    public Driver(String id, String name, String lastname, String profil_picture, String phone_number, String adress, String password) {
        super(id, name, lastname, profil_picture, phone_number, adress, password);
    }

    public Driver(String id, String name, String lastname, String profil_picture, String phone_number, String adress, String password, String driving_license, String traffic_license, boolean is_active) {
        super(id, name, lastname, profil_picture, phone_number, adress, password);
        this.driving_license = driving_license;
        this.traffic_license = traffic_license;
        this.is_active = is_active;
    }


}
