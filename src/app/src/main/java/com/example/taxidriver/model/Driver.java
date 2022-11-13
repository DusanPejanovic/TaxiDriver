package com.example.taxidriver.model;

import java.util.List;

public class Driver extends User{

    String driving_license;
    String traffic_license;
    boolean is_active;

    public Driver(String id, String name, String lastname, String email, String profilPicture, String phoneNumber, String adress, String password, List<Message> messagesSent, List<Message> messagesRecived, List<RejectionLetter> rejectionLetters) {
        super(id, name, lastname, email, profilPicture, phoneNumber, adress, password, messagesSent, messagesRecived, rejectionLetters);
    }

    public Driver(String id, String name, String lastname, String email, String profilPicture, String phoneNumber, String adress, String password, List<Message> messagesSent, List<Message> messagesRecived, List<RejectionLetter> rejectionLetters, String driving_license, String traffic_license, boolean is_active) {
        super(id, name, lastname, email, profilPicture, phoneNumber, adress, password, messagesSent, messagesRecived, rejectionLetters);
        this.driving_license = driving_license;
        this.traffic_license = traffic_license;
        this.is_active = is_active;
    }
}



