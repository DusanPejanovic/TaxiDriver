package com.example.taxidriver.model;

import java.time.LocalDateTime;

public class DriveReport {
    private LocalDateTime date;
    private Integer rides;
    private Integer mileage;
    private Integer spent;

    public DriveReport(LocalDateTime date, Integer rides, Integer mileage, Integer spent) {
        this.date = date;
        this.rides = rides;
        this.mileage = mileage;
        this.spent = spent;
    }

    public DriveReport() {
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Integer getRides() {
        return rides;
    }

    public void setRides(Integer rides) {
        this.rides = rides;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Integer getSpent() {
        return spent;
    }

    public void setSpent(Integer spent) {
        this.spent = spent;
    }
}
