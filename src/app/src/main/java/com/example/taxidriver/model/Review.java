package com.example.taxidriver.model;

public class Review {

    private String id;
    private Integer price;
    private String comment;

    private User user;
    private Drive drive;

    public Review(String id, Integer price, String comment, User user, Drive drive) {
        this.id = id;
        this.price = price;
        this.comment = comment;
        this.user = user;
        this.drive = drive;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }


}
