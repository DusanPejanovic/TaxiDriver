package com.example.taxidriver.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Drive {

    private String id;

    private Integer cost; //
    private Integer mileage; //
    private DrivingStatus status;

    private LocalDateTime startTime; //
    private LocalDateTime endTime; // vt
    private Duration estimatedTime;


    private Driver driver;
    private VehicleType vehicleType;



    private List<Message> messages; // referenca ka inboxu
    private Route route; // putanju
    private List<Review> reviews; // ocena i komentar
    private List<Passenger> passengers; // broj putinka i profili putnika
    private List<RejectionLetter> rejectionLetters;


    private boolean panicFlag;
    private boolean babyFlag;
    private boolean petFlag;
    private boolean splitFlag;



    public Drive(String id, Integer cost, Integer mileage, LocalDateTime startTime, LocalDateTime endTime, List<Message> messages, List<Review> reviews, List<Passenger> passengers) {
        this.id = id;
        this.cost = cost;
        this.mileage = mileage;
        this.startTime = startTime;
        this.endTime = endTime;
        this.messages = messages;
        this.reviews = reviews;
        this.passengers = passengers;
    }

    public Drive(String id, LocalDateTime beginTime, LocalDateTime endTime, Integer cost, Integer mileage, Duration estimatedTime, boolean panicButton, boolean babyDroven, boolean petDroven, boolean splitFare, DrivingStatus drivingStatus, List<Message> messages, Route route, List<Review> reviews, List<Passenger> passengers, List<RejectionLetter> rejectionLetters, VehicleType vehicleType, Driver driver) {
        this.id = id;
        this.startTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.mileage = mileage;
        this.estimatedTime = estimatedTime;
        this.panicFlag = panicButton;
        this.babyFlag = babyDroven;
        this.petFlag = petDroven;
        this.splitFlag = splitFare;
        this.status = drivingStatus;
        this.messages = messages;
        this.route = route;
        this.reviews = reviews;
        this.passengers = passengers;
        this.rejectionLetters = rejectionLetters;
        this.vehicleType = vehicleType;
        this.driver = driver;
    }

    public Drive(String id, LocalDateTime beginTime, LocalDateTime endTime, Integer cost, Integer mileage, Route route) {
        this.id = id;
        this.startTime = beginTime;
        this.endTime = endTime;
        this.cost = cost;
        this.mileage = mileage;
        this.route = route;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
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

    public boolean isPanicFlag() {
        return panicFlag;
    }

    public void setPanicFlag(boolean panicFlag) {
        this.panicFlag = panicFlag;
    }

    public boolean isBabyFlag() {
        return babyFlag;
    }

    public void setBabyFlag(boolean babyFlag) {
        this.babyFlag = babyFlag;
    }

    public boolean isPetFlag() {
        return petFlag;
    }

    public void setPetFlag(boolean petFlag) {
        this.petFlag = petFlag;
    }

    public boolean isSplitFlag() {
        return splitFlag;
    }

    public void setSplitFlag(boolean splitFlag) {
        this.splitFlag = splitFlag;
    }

    public DrivingStatus getStatus() {
        return status;
    }

    public void setStatus(DrivingStatus status) {
        this.status = status;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Route getRoutes() {
        return route;
    }

    public void setRoutes(Route route) {
        this.route = route;
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
