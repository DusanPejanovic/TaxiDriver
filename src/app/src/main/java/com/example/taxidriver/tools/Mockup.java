package com.example.taxidriver.tools;

import com.example.taxidriver.model.Drive;
import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.model.Location;
import com.example.taxidriver.model.Passenger;
import com.example.taxidriver.model.Route;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Mockup {

    public static Passenger getPassenger(){
        return new Passenger("1", "Pera", "Peric", "pera@email.com", "z", "+381957291", "Novi Sad, Narodnog Fronta 15", "sifra123");
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

    public static ArrayList<Drive> getRides(){
        ArrayList<Drive> rides = new ArrayList<Drive>();
        rides.add(new Drive("1", LocalDateTime.of(2022, 11, 14, 0, 0), LocalDateTime.of(2022, 11, 14, 1, 0), 1500, 10, new ArrayList<>()));
        rides.add(new Drive("2", LocalDateTime.of(2022, 11, 14, 1, 15), LocalDateTime.of(2022, 11, 14, 1, 45), 500, 2,new ArrayList<>()));
        rides.add(new Drive("3", LocalDateTime.of(2022, 11, 15, 0, 0), LocalDateTime.of(2022, 11, 15, 1, 0), 2000, 15,new ArrayList<>()));
        rides.add(new Drive("4", LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 30, 3,new ArrayList<>()));
        rides.add(new Drive("5", LocalDateTime.of(2022, 11, 16, 7, 0), LocalDateTime.of(2022, 11, 16, 9, 0), 1500, 10,new ArrayList<>()));
        rides.add(new Drive("6", LocalDateTime.of(2022, 11, 18, 0, 0), LocalDateTime.of(2022, 11, 18, 1, 0), 1500, 10,new ArrayList<>()));

        return rides;
    }
}
