package com.example.taxidriver.model;

import androidx.annotation.NonNull;

import java.time.LocalDateTime;

public class Payment {

    private String id;
    private LocalDateTime dateTime;
    private int totalPrice;

    public Payment(String id, LocalDateTime dateTime, int totalPrice) {
        this.id = id;
        this.dateTime = dateTime;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }


    @NonNull
    @Override
    public String toString() {
        return "Payment{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
