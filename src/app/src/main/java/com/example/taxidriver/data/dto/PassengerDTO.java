package com.example.taxidriver.data.dto;

import com.example.taxidriver.domain.model.Passenger;
import com.example.taxidriver.domain.model.User;

public class PassengerDTO {

    private Long id;

    private String name;

    private String surname;

    private String password;

    private String profilePicture;

    private String telephoneNumber;

    private String email;

    private String address;

    public PassengerDTO(Long id, String name, String surname, String password, String profilePicture, String telephoneNumber, String email, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.profilePicture = profilePicture;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public PassengerDTO(String name, String surname, String password, String profilePicture, String telephoneNumber, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.profilePicture = profilePicture;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.address = address;
    }

    public PassengerDTO(User userLoged) {
        this.id = userLoged.getId();
        this.name = userLoged.getName();
        this.surname = userLoged.getSurname();
        this.profilePicture = userLoged.getProfilePicture();
        this.telephoneNumber = userLoged.getTelephoneNumber();
        this.email = userLoged.getEmail();
        this.address = userLoged.getAddress();
    }

    public Long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String lastname) {
        this.surname = lastname;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String phoneNumber) {
        this.telephoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String address) {
        this.email = address;
    }

    public static PassengerDTO passengerToDTO(Passenger passenger){
        return new PassengerDTO(passenger.getId(),passenger.getName(), passenger.getSurname(),
                "ovaj podatak se ne prikazuje",
                passenger.getProfilePicture(),passenger.getTelephoneNumber(), passenger.getEmail(),passenger.getAddress());
    }

    public static Passenger DTOToPassenger(PassengerDTO passengerDTO){
        Passenger passenger = new Passenger();
        passenger.setId(passengerDTO.getId());
        passenger.setAddress(passengerDTO.getAddress());
        passenger.setName(passengerDTO.getName());
        passenger.setSurname(passengerDTO.getSurname());
        passenger.setPassword(passengerDTO.getPassword());
        passenger.setProfilePicture(passengerDTO.getProfilePicture());
        passenger.setTelephoneNumber(passengerDTO.getTelephoneNumber());
        passenger.setEmail(passengerDTO.getEmail());
        return passenger;
    }

    public Passenger passengerChanging(Passenger passenger){
        if(this.address != null){
            passenger.setAddress(this.getAddress());
        }
        if(this.email != null){
            passenger.setEmail(this.getEmail());
        }
        if(this.profilePicture != null){
            passenger.setProfilePicture(this.getProfilePicture());
        }
        if(this.telephoneNumber != null){
            passenger.setTelephoneNumber(this.getTelephoneNumber());
        }
        if(this.getSurname() != null){
            passenger.setSurname(this.getSurname());
        }
        if(this.getName() != null){
            passenger.setName(this.getName());
        }
        return passenger;
    }

    public boolean isPassengerDTOEmpty(){
        if(this.address == null && this.getName() == null && this.getSurname() == null && this.telephoneNumber == null
                && this.profilePicture == null && this.email == null){
            return true;
        }
        return false;
    }

    public boolean invalidDTOData(){
        if(this.getName().length() > 20)
            return true;
        if(this.getSurname().length() > 20)
            return true;
        if (this.getAddress().length() > 40)
            return true;
        //if (this.getEmail().contains("@") == false )
        //    return true;
        if (this.getTelephoneNumber().length() > 13)
            return true;
        return false;
    }

}