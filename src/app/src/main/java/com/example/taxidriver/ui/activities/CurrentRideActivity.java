package com.example.taxidriver.ui.activities;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.taxidriver.R;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Polyline;

import java.util.ArrayList;
import java.util.List;

public class CurrentRideActivity extends AppCompatActivity {

    MapView mapView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_current_ride);

        String rideId = getIntent().getStringExtra("rideId");
        String startLatitude = getIntent().getStringExtra("startLat");
        String startLongitude = getIntent().getStringExtra("startLon");
        String endLatitude = getIntent().getStringExtra("endLat");
        String endLongitude = getIntent().getStringExtra("endLon");

        mapView = findViewById(R.id.map_view);


        GeoPoint startPoint = new GeoPoint(Double.parseDouble(startLatitude), Double.parseDouble(startLongitude));
        GeoPoint endPoint = new GeoPoint(Double.parseDouble(endLatitude), Double.parseDouble(endLongitude));
        List<GeoPoint> list = new ArrayList<>();
        list.add(startPoint);
        list.add(endPoint);
        Polyline roadOverlay = new Polyline();
        roadOverlay.setPoints(list);
        roadOverlay.setColor(Color.RED);
        roadOverlay.setWidth(10f);
        mapView.getOverlays().add(roadOverlay);






        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(16);
        mapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));
    }


}