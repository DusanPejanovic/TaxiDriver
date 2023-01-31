package com.example.taxidriver.ui.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.domain.viewmodel.CurrentRideViewModel;
import com.example.taxidriver.domain.viewmodel.RideHistoryViewModel;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;
import com.example.taxidriver.ui.fragments.HistoryFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.Polyline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CurrentRideActivity extends AppCompatActivity {

    MapView mapView;
    private CurrentRideViewModel viewModel;

    private Handler handler = new Handler();

    private Runnable vehicleLocationRunnable = new Runnable() {
        @Override
        public void run() {
            viewModel.fetchCurrentLocationVehicle();
            handler.postDelayed(vehicleLocationRunnable, 5000);
        }
    };

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



        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(17);
        mapView.getController().setCenter(startPoint);


        Marker driverMarker = new Marker(mapView);
        driverMarker.setPosition(startPoint);
        driverMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        driverMarker.setFlat(true);
        driverMarker.setTitle("Driver");
        driverMarker.setSubDescription("Standard");
        mapView.getOverlays().add(driverMarker);


        String apiKey = "5b3ce3597851110001cf6248ef20a8142c654e9dba129cbcb06678f1";

        String baseUrl = "https://api.openrouteservice.org/v2/directions/driving-car";
        String requestUrl = baseUrl + "?api_key=" + apiKey + "&start=" + startLongitude + "," + startLatitude + "&end=" + endLongitude + "," + endLatitude;

// Use a HTTP client library such as OkHttp to make the API request
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(requestUrl).build();


        FragmentManager fragmentManager = getSupportFragmentManager();

        viewModel = new ViewModelProvider(this).get(CurrentRideViewModel.class);


        viewModel.getVehicle().observe(this, locationDTO3 -> {

                    if(locationDTO3 != null)
                    {
                        GeoPoint newLocation = new GeoPoint(locationDTO3.getLatitude(), locationDTO3.getLongitude());
                        driverMarker.setPosition(newLocation);
                        mapView.invalidate();
                    }
                }
        );

        viewModel.fetchCurrentLocationVehicle();
        handler.postDelayed(vehicleLocationRunnable, 5000);




        client.newCall(request).enqueue(new Callback() {
                                            @Override
                                            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                                            }

                                            @Override
                                            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                                String responseBody = response.body().string();
                                                JSONObject jsonResponse = null;
                                                JSONArray coordinates = null;
                                                JSONObject coordinates1 = null;
                                                try {
                                                    jsonResponse = new JSONObject(responseBody);
                                                    JSONArray routes = jsonResponse.getJSONArray("features");
                                                    JSONObject route = routes.getJSONObject(0);
                                                    coordinates1 = route.getJSONObject("geometry");
                                                    coordinates = coordinates1.getJSONArray("coordinates");
                                                } catch (JSONException e) {
                                                    e.printStackTrace();
                                                }

                                                List<GeoPoint> routePoints = new ArrayList<>();
                                                for (int i = 0; i < coordinates.length(); i++) {
                                                    JSONArray point = null;
                                                    double latitude = 0;
                                                    double longitude = 0;
                                                    try {
                                                        point = coordinates.getJSONArray(i);

                                                        latitude = point.getDouble(1);
                                                        longitude = point.getDouble(0);
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                    routePoints.add(new GeoPoint(latitude, longitude));
                                                }

                                                // Draw the route on the map
                                                Polyline roadOverlay = new Polyline();
                                                roadOverlay.setPoints(routePoints);
                                                roadOverlay.setColor(Color.BLACK);
                                                roadOverlay.setWidth(8f);
                                                mapView.getOverlays().add(roadOverlay);
                                                mapView.invalidate();
                                            }
                                        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(vehicleLocationRunnable);
        // handler.removeCallbacks(scheduledRidesRunnable);
    }

}