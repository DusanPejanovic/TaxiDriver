package com.example.taxidriver.tools;

import com.example.taxidriver.model.Passenger;

public class Mockup {
    public static Passenger getPassenger(){
        return new Passenger("1", "Pera", "Peric", "pera@email.com", "z", "+381957291", "Novi Sad, Narodnog Fronta 15", "sifra123");
    }
}
