package com.example.taxidriver.tools;

import com.example.taxidriver.R;
import com.example.taxidriver.model.Cinema;

import java.util.ArrayList;
import java.util.List;


public class Mokap {

    public static ArrayList<Cinema> getCinemas(){
        ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
        Cinema u1 = new Cinema("Arena", "Cineplexx 3D", -1);
        Cinema u2 = new Cinema("Cinestar", "Najnoviji 5D", -1);
        Cinema u3 = new Cinema("Jadran", "Tradicionalni u mirnom ambijentu", -1);

        cinemas.add(u1);
        cinemas.add(u2);
        cinemas.add(u3);

        return cinemas;
    }

}
