package com.example.taxidriver.model;

import androidx.annotation.NonNull;

import java.util.List;

public class Location {

    private String id;
    private Integer longitude;
    private Integer latitude;

    private List<Route> routesStartHere;
    private List<Route> routesEndHere;

    private List<Route> favouriteRoutesStartHere;
    private List<Route> favouriteRoutesEndHere;


    public Location(String id, Integer longitude, Integer latitude, List<Route> routesStartHere, List<Route> routesEndHere, List<Route> favouriteRoutesStartHere, List<Route> favouriteRoutesEndHere) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
        this.routesStartHere = routesStartHere;
        this.routesEndHere = routesEndHere;
        this.favouriteRoutesStartHere = favouriteRoutesStartHere;
        this.favouriteRoutesEndHere = favouriteRoutesEndHere;
    }

    public Location(String id, Integer longitude, Integer latitude) {
        this.id = id;
        this.longitude = longitude;
        this.latitude = latitude;
    }




    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getLongitude() {
        return longitude;
    }

    public void setLongitude(Integer longitude) {
        this.longitude = longitude;
    }

    public Integer getLatitude() {
        return latitude;
    }

    public void setLatitude(Integer latitude) {
        this.latitude = latitude;
    }

    public List<Route> getRoutesStartHere() {
        return routesStartHere;
    }

    public void setRoutesStartHere(List<Route> routesStartHere) {
        this.routesStartHere = routesStartHere;
    }

    public List<Route> getRoutesEndHere() {
        return routesEndHere;
    }

    public void setRoutesEndHere(List<Route> routesEndHere) {
        this.routesEndHere = routesEndHere;
    }

    public List<Route> getFavouriteRoutesStartHere() {
        return favouriteRoutesStartHere;
    }

    public void setFavouriteRoutesStartHere(List<Route> favouriteRoutesStartHere) {
        this.favouriteRoutesStartHere = favouriteRoutesStartHere;
    }

    public List<Route> getFavouriteRoutesEndHere() {
        return favouriteRoutesEndHere;
    }

    public void setFavouriteRoutesEndHere(List<Route> favouriteRoutesEndHere) {
        this.favouriteRoutesEndHere = favouriteRoutesEndHere;
    }


    @NonNull
    @Override
    public String toString() {
        return "Location{" +
                "id='" + id + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", routesStartHere=" + routesStartHere +
                ", routesEndHere=" + routesEndHere +
                ", favouriteRoutesStartHere=" + favouriteRoutesStartHere +
                ", favouriteRoutesEndHere=" + favouriteRoutesEndHere +
                '}';
    }
}
