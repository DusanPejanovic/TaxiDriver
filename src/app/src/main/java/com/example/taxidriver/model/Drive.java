package com.example.taxidriver.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Drive {
    String id;
    LocalDateTime beginTime;
    LocalDateTime endTime;
    Integer cost;
    Integer mileage;
    Duration estimatedTime;
    boolean panicButton;
    boolean babyDroven;
    boolean petDroven;
    boolean splitFare;
    DrivingStatus drivingStatus;
    List<Message> messages;
    List<Route> routes;
    List<Review> reviews;
    List<Passenger> passengers;
    List<RejectionLetter> rejectionLetters;
    VehicleType vehicleType;
    Driver driver;

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public Drive(String id, LocalDateTime beginTime, LocalDateTime endTime, Integer cost, Integer mileage, Duration estimatedTime, boolean panicButton, boolean babyDroven, boolean petDroven, boolean splitFare, DrivingStatus drivingStatus, List<Message> messages, List<Route> routes, List<Review> reviews, List<Passenger> passengers, List<RejectionLetter> rejectionLetters, VehicleType vehicleType, Driver driver) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.mileage = mileage;
        this.estimatedTime = estimatedTime;
        this.panicButton = panicButton;
        this.babyDroven = babyDroven;
        this.petDroven = petDroven;
        this.splitFare = splitFare;
        this.drivingStatus = drivingStatus;
        this.messages = messages;
        this.routes = routes;
        this.reviews = reviews;
        this.passengers = passengers;
        this.rejectionLetters = rejectionLetters;
        this.vehicleType = vehicleType;
        this.driver = driver;
    }

    public Drive(String id, LocalDateTime beginTime, LocalDateTime endTime, Integer cost, Integer mileage, List<Route> routes) {
        this.id = id;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.mileage = mileage;
        this.routes = routes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Duration getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Duration estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public boolean isPanicButton() {
        return panicButton;
    }

    public void setPanicButton(boolean panicButton) {
        this.panicButton = panicButton;
    }

    public boolean isBabyDroven() {
        return babyDroven;
    }

    public void setBabyDroven(boolean babyDroven) {
        this.babyDroven = babyDroven;
    }

    public boolean isPetDroven() {
        return petDroven;
    }

    public void setPetDroven(boolean petDroven) {
        this.petDroven = petDroven;
    }

    public boolean isSplitFare() {
        return splitFare;
    }

    public void setSplitFare(boolean splitFare) {
        this.splitFare = splitFare;
    }

    public DrivingStatus getDrivingStatus() {
        return drivingStatus;
    }

    public void setDrivingStatus(DrivingStatus drivingStatus) {
        this.drivingStatus = drivingStatus;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public List<RejectionLetter> getRejectionLetters() {
        return rejectionLetters;
    }

    public void setRejectionLetters(List<RejectionLetter> rejectionLetters) {
        this.rejectionLetters = rejectionLetters;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
}
