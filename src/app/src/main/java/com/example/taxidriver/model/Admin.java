package com.example.taxidriver.model;

import java.util.List;

public class Admin extends User{


    public Admin(String id, String name, String lastname, String profilPicture, String phoneNumber, String adress, String password, List<Message> messagesSent, List<Message> messagesRecived, List<RejectionLetter> rejectionLetters) {
        super(id, name, lastname, profilPicture, phoneNumber, adress, password, messagesSent, messagesRecived, rejectionLetters);
    }
}
