package com.example.taxidriver.model;
import java.util.ArrayList;
import java.util.List;
import androidx.annotation.Nullable;

public class User {
    String id;
    String name;
    String lastname;
    String profilPicture;
    String phoneNumber;
    String adress;
    String password;
    List<Message> messagesSent;
    List<Message> messagesRecived;
    List<RejectionLetter> rejectionLetters;
    boolean is_blocked = false;

    public User(String id, String name, String lastname, String profilPicture, String phoneNumber, String adress, String password, List<Message> messagesSent, List<Message> messagesRecived, List<RejectionLetter> rejectionLetters) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.profilPicture = profilPicture;
        this.phoneNumber = phoneNumber;
        this.adress = adress;
        this.password = password;
        this.messagesSent = messagesSent;
        this.messagesRecived = messagesRecived;
        this.rejectionLetters = rejectionLetters;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilPicture() {
        return profilPicture;
    }

    public void setProfilPicture(String profilPicture) {
        this.profilPicture = profilPicture;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_blocked() {
        return is_blocked;
    }

    public void setIs_blocked(boolean is_blocked) {
        this.is_blocked = is_blocked;
    }

    public List<Message> getMessagesSent() {
        return messagesSent;
    }

    public void setMessagesSent(List<Message> messagesSent) {
        this.messagesSent = messagesSent;
    }

    public List<Message> getMessagesRecived() {
        return messagesRecived;
    }

    public void setMessagesRecived(List<Message> messagesRecived) {
        this.messagesRecived = messagesRecived;
    }

    public List<RejectionLetter> getRejectionLetters() {
        return rejectionLetters;
    }

    public void setRejectionLetters(List<RejectionLetter> rejectionLetters) {
        this.rejectionLetters = rejectionLetters;
    }
}
