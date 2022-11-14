package com.example.taxidriver.model;

import java.util.List;

public class Driver extends User{

    String driving_license;
    String traffic_license;
    boolean is_active;
    Vehicle vehicle;
    List<Drive> drives;

    public Driver(String id, String name, String lastname, String email, String profilePicture, String phoneNumber, String adress, String password, List<Message> messagesSent, List<Message> messagesRecived, List<RejectionLetter> rejectionLetters, String driving_license, String traffic_license, boolean is_active, Vehicle vehicle, List<Drive> drives) {
        super(id, name, lastname, email, profilePicture, phoneNumber, adress, password, messagesSent, messagesRecived, rejectionLetters);
        this.driving_license = driving_license;
        this.traffic_license = traffic_license;
        this.is_active = is_active;
        this.vehicle = vehicle;
        this.drives = drives;
    }

    public String getDriving_license() {
        return driving_license;
    }

    public void setDriving_license(String driving_license) {
        this.driving_license = driving_license;
    }

    public String getTraffic_license() {
        return traffic_license;
    }

    public void setTraffic_license(String traffic_license) {
        this.traffic_license = traffic_license;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public List<Drive> getDrives() {
        return drives;
    }

    public void setDrives(List<Drive> drives) {
        this.drives = drives;
    }
}



