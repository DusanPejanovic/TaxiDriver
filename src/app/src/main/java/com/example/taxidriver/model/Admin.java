package com.example.taxidriver.model;

public class Admin extends User{

    public Admin(String id, String name, String lastname, String profil_picture, String phone_number, String adress, String password) {
        super(id, name, lastname, profil_picture, phone_number, adress, password);
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", profil_picture='" + profil_picture + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", adress='" + adress + '\'' +
                ", password='" + password + '\'' +
                ", blocked=" + is_blocked +
                '}';
    }
}
