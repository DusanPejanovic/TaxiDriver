package com.example.taxidriver.model;

public class User {
    String id;
    String name;
    String lastname;
    String profil_picture;
    String phone_number;
    String adress;
    String password;
    boolean is_blocked = false;

    public User(String id, String name, String lastname, String profil_picture, String phone_number, String adress, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.profil_picture = profil_picture;
        this.phone_number = phone_number;
        this.adress = adress;
        this.password = password;
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

    public String getProfil_picture() {
        return profil_picture;
    }

    public void setProfil_picture(String profil_picture) {
        this.profil_picture = profil_picture;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

    public boolean isBlocked() {
        return is_blocked;
    }

    public void setBlocked(boolean blocked) {
        this.is_blocked = blocked;
    }

    @Override
    public String toString() {
        return "User{" +
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
