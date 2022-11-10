package com.example.taxidriver.model;
import java.time.LocalDateTime;

public class Message {
    String id;
    String body;
    LocalDateTime timeSent;
    MessageType messageType;
    User sentBy;
    User sentTo;
    Drive drive;

    public Message(String id, String body, LocalDateTime timeSent, MessageType messageType, User sentBy, User sentTo, Drive drive) {
        this.id = id;
        this.body = body;
        this.timeSent = timeSent;
        this.messageType = messageType;
        this.sentBy = sentBy;
        this.sentTo = sentTo;
        this.drive = drive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(LocalDateTime timeSent) {
        this.timeSent = timeSent;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public User getSentBy() {
        return sentBy;
    }

    public void setSentBy(User sentBy) {
        this.sentBy = sentBy;
    }

    public User getSentTo() {
        return sentTo;
    }

    public void setSentTo(User sentTo) {
        this.sentTo = sentTo;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }
}
