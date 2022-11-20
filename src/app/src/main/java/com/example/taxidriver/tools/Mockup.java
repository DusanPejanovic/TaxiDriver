package com.example.taxidriver.tools;

import com.example.taxidriver.model.Drive;
import com.example.taxidriver.model.DrivingStatus;
import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.model.Location;
import com.example.taxidriver.model.Driver;
import com.example.taxidriver.model.Message;
import com.example.taxidriver.model.MessageType;
import com.example.taxidriver.model.Passenger;
import com.example.taxidriver.model.Review;

import org.xml.sax.DTDHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.Duration;

public class Mockup {


    public static List<Passenger> getPassengers(){
        List<Passenger> passengers = new ArrayList<Passenger>();

        Passenger p1 = new Passenger("1", "Pera", "Peric", "pera", "z", "+381957291", "Novi Sad, Narodnog Fronta 15", "admin", null, null, null, null, null, null, null);

        passengers.add(p1);

        return passengers;

    }

    public static List<Driver> getDrivers()
    {
        List<Driver> drivers = new ArrayList<Driver>();

        Driver d1 = new Driver("1", "Vozac", "Najbrzi", "jova", "sga", "+381999999999", "Novi Sad, Bulevar Oslobodjenja 15", "admin", null, null, null, "A","Saobracajna", true, null, null);

        drivers.add(d1);

        return drivers;
    }


    public static List<Drive> getDrives2() {


        Drive d1 = new Drive("1",  LocalDateTime.of(2022, 11, 14, 0, 0), LocalDateTime.of(2022, 11, 14, 1, 0), 1500, 10, null, false, false, false, false, DrivingStatus.COMPLETED, getMessages(),null,getReviews(),getPassengers(),null,null, getDriver());
        Drive d2 = new Drive("2", LocalDateTime.of(2022, 11, 14, 1, 15), LocalDateTime.of(2022, 11, 14, 1, 45), 500, 2, null, false, false, false, false, DrivingStatus.COMPLETED, getMessages(),null,getReviews(),getPassengers(),null,null, getDriver());
        Drive d3 = new Drive("3", LocalDateTime.of(2022, 11, 15, 0, 0), LocalDateTime.of(2022, 11, 15, 1, 0), 2000, 15, null, false, false, false, false, DrivingStatus.COMPLETED, getMessages(),null,getReviews(),getPassengers(),null,null, getDriver());
        Drive d4 = new Drive("4",LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 30, 3, null, false, false, false, false, DrivingStatus.COMPLETED, getMessages(),null,getReviews(),getPassengers(),null,null, getDriver());
        Drive d5 = new Drive("5",LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 1500, 10, null, false, false, false, false, DrivingStatus.COMPLETED, getMessages(),null,getReviews(),getPassengers(),null,null, getDriver());

        List<Drive> drives = new ArrayList<>();

        drives.add(d1);
        drives.add(d2);
        drives.add(d3);
        drives.add(d4);
        drives.add(d5);

        return drives;
    }

        public static Passenger getPassenger(){
        return new Passenger("1", "Pera", "Peric", "pera@email.com", "z", "+381957291", "Novi Sad, Narodnog Fronta 15", "sifra123", null, null, null, null, null, null, null);
    }

    public static List<Review> getReviews(){
        Review r1 = new Review("1", 130, "Super vozac!", getPassenger(),getDrive());
        Review r2 = new Review("2", 120, "Los vozac!", getPassenger(),getDrive());
        Review r3 = new Review("3", 150, "Srednje vozac!", getPassenger(),getDrive());
        Review r4 = new Review("4", 200, "Bas los vozac!", getPassenger(),getDrive());
        Review r5 = new Review("5", 600, "Prejak vozac!", getPassenger(),getDrive());

        List<Review> reviews = new ArrayList<>();

        reviews.add(r1);
        reviews.add(r2);
        reviews.add(r3);
        reviews.add(r4);
        reviews.add(r5);

        return reviews;

    }



        public static Driver getDriver(){
        return new Driver("1", "Vozac", "Najbrzi", "vozac@gmail.com", "sga", "+381999999999", "Novi Sad, Bulevar Oslobodjenja 15", "sifra", getMessages(), null, null, "A","Saobracajna", true, null, null);

    }

    public static ArrayList<FavoriteRoute> getFavoriteRoutes(){
        ArrayList<FavoriteRoute> list = new ArrayList<FavoriteRoute>();
        FavoriteRoute fr1 = new FavoriteRoute("1", getPassenger(), new Location("1", 1, 1), new Location("2", 2, 2));
        FavoriteRoute fr2 = new FavoriteRoute("2", getPassenger(), new Location("3", 3, 3), new Location("4", 4, 4));
        FavoriteRoute fr3 = new FavoriteRoute("3", getPassenger(), new Location("5", 5, 5), new Location("6", 6, 6));
        FavoriteRoute fr4 = new FavoriteRoute("4", getPassenger(), new Location("7", 7, 7), new Location("8", 8, 8));
        FavoriteRoute fr5 = new FavoriteRoute("5", getPassenger(), new Location("1", 1, 1), new Location("4", 4, 4));
        FavoriteRoute fr6 = new FavoriteRoute("6", getPassenger(), new Location("9", 9, 9), new Location("6", 6, 6));
        list.add(fr1);
        list.add(fr2);
        list.add(fr3);
        list.add(fr4);
        list.add(fr5);
        list.add(fr6);
        return list;
    }

    public static ArrayList<Drive> getDrives(){
        ArrayList<Drive> rides = new ArrayList<Drive>();
        rides.add(new Drive("1", LocalDateTime.of(2022, 11, 14, 0, 0), LocalDateTime.of(2022, 11, 14, 1, 0), 1500, 10, new ArrayList<>()));
        rides.add(new Drive("2", LocalDateTime.of(2022, 11, 14, 1, 15), LocalDateTime.of(2022, 11, 14, 1, 45), 500, 2,new ArrayList<>()));
        rides.add(new Drive("3", LocalDateTime.of(2022, 11, 15, 0, 0), LocalDateTime.of(2022, 11, 15, 1, 0), 2000, 15,new ArrayList<>()));
        rides.add(new Drive("4", LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 30, 3,new ArrayList<>()));
        rides.add(new Drive("5", LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 1500, 10,new ArrayList<>()));
        rides.add(new Drive("6", LocalDateTime.of(2022, 11, 18, 0, 0), LocalDateTime.of(2022, 11, 18, 1, 0), 1500, 10,new ArrayList<>()));

        return rides;
    }

    public static Drive getDrive(){
        return new Drive("1", LocalDateTime.of(2022, 11, 14, 0, 0), LocalDateTime.of(2022, 11, 14, 1, 0), 1500, 10, new ArrayList<>());
    }

    public static ArrayList<Message> getMessages(){
        ArrayList<Message> messages = new ArrayList<>();
        messages.add(new Message("1", "Sve je uredu.",LocalDateTime.of(2022, 11, 14, 0, 0), MessageType.Drive,getPassenger(), getDriver(), getDrive()));
        messages.add(new Message("1", "Sve je uredu.",LocalDateTime.of(2022, 11, 15, 0, 0),  MessageType.Drive,getPassenger(), getDriver(), getDrive()));
        messages.add(new Message("1", "VOZILO KASNI.",LocalDateTime.of(2022, 11, 13, 0, 0),  MessageType.Support,getPassenger(), getDriver(), getDrive()));
        messages.add(new Message("1", "PANIKA.",LocalDateTime.of(2022, 11, 12, 0, 0),  MessageType.Panic,getPassenger(), getDriver(), getDrive()));
        return messages;
    }
}
