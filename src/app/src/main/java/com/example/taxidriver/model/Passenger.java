package com.example.taxidriver.model;

public class Passenger extends User{
    // TODO add email
    public Passenger(String id, String name, String lastname, String email, String profilePicture, String phoneNumber, String adress, String password) {
        super(id, name, lastname, email, profilePicture, phoneNumber, adress, password);
    }

}
