package com.example.taxidriver.model;

import java.time.LocalDateTime;

public class RejectionLetter {

    private String id;
    private String reasoon;
    private LocalDateTime dateTime;


    public RejectionLetter(String id, String reasoon, LocalDateTime dateTime) {
        this.id = id;
        this.reasoon = reasoon;
        this.dateTime = dateTime;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReasoon() {
        return reasoon;
    }

    public void setReasoon(String reasoon) {
        this.reasoon = reasoon;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

}
