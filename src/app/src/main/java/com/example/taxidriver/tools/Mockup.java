package com.example.taxidriver.tools;

import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.model.Location;
import com.example.taxidriver.model.Passenger;
import com.example.taxidriver.model.Route;

import java.util.ArrayList;
import java.util.List;

public class Mockup {
    public static Passenger getPassenger(){
        return new Passenger("1", "Pera", "Peric", "pera@email.com", "z", "+381957291", "Novi Sad, Narodnog Fronta 15", "sifra123");
    }
    public static ArrayList<FavoriteRoute> getFavoriteRoutes(){
        ArrayList<FavoriteRoute> list = new ArrayList<FavoriteRoute>();
        FavoriteRoute fr1 = new FavoriteRoute("1", getPassenger(), new Location("1", 21, 43), new Location("2", 23, 45));
        FavoriteRoute fr2 = new FavoriteRoute("2", getPassenger(), new Location("3", 23, 45), new Location("4", 25, 47));
        FavoriteRoute fr3 = new FavoriteRoute("3", getPassenger(), new Location("5", 25, 47), new Location("6", 27, 49));
        FavoriteRoute fr4 = new FavoriteRoute("4", getPassenger(), new Location("7", 27, 49), new Location("8", 29, 51));
        FavoriteRoute fr5 = new FavoriteRoute("5", getPassenger(), new Location("1", 21, 43), new Location("4", 25, 47));
        FavoriteRoute fr6 = new FavoriteRoute("6", getPassenger(), new Location("9", 29, 51), new Location("6", 27, 49));
        list.add(fr1);
        list.add(fr2);
        list.add(fr3);
        list.add(fr4);
        list.add(fr5);
        list.add(fr6);



        return list;
    }
}
