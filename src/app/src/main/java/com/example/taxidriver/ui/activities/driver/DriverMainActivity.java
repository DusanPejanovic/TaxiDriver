package com.example.taxidriver.ui.activities.driver;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.dto.LocationDTO3;
import com.example.taxidriver.data.dto.PendingRideResponseDTO;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.data.repository.DriverRepository;
import com.example.taxidriver.domain.viewmodel.DriverMainViewModel;
import com.example.taxidriver.ui.activities.passenger.PassengerMainActivity;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DriverMainActivity extends AppCompatActivity {

    private MapView mapView;
    DriverMainViewModel driverMainViewModel;
    SharedPreferences prefs = TaxiDriver.getAppContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);
    AlertDialog acceptRideDialog;


    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            DriverRepository repository = new DriverRepository();
            repository.isTherePendingRide(new Callback<RideDTO>() {
                @Override
                public void onResponse(Call<RideDTO> call, Response<RideDTO> response) {

                    if(response.isSuccessful())
                    {
                        RideDTO rideDTO = response.body();
                        int x = 3;
                        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(DriverMainActivity.this);
                        LayoutInflater inflater = DriverMainActivity.this.getLayoutInflater();
                        View dialogView = inflater.inflate(R.layout.accept_ride_dialog, null);
                        Button acceptRideButton = dialogView.findViewById(R.id.accept_ride);


                        acceptRideButton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                acceptRideDialog.dismiss();
                            }
                        });
                        ProgressBar progressBar = dialogView.findViewById(R.id.progress_bar);
                        EditText destinationEditText = dialogView.findViewById(R.id.destination2);
                        EditText departureEditText = dialogView.findViewById(R.id.departure2);
                        TextView timeTextView = dialogView.findViewById(R.id.time2);
                        TextView priceTextView = dialogView.findViewById(R.id.price2);
                        CheckBox petCheckBox = dialogView.findViewById(R.id.pet2);
                        CheckBox kidCheckBox = dialogView.findViewById(R.id.kid2);
                        String departure = rideDTO.getLocations().getDeparture().getAddress();
                        String destination = rideDTO.getLocations().getDestination().getAddress();
                        LocalDateTime startTime = LocalDateTime.parse(rideDTO.getStartTime());
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
                        timeTextView.setText("Time: "+startTime.format(formatter));
                        priceTextView.setText("Price: " + rideDTO.getTotalCost().toString()+ " $");
                        departureEditText.setText(departure);
                        destinationEditText.setText(destination);
                        petCheckBox.setChecked(rideDTO.isPetTransport());
                        kidCheckBox.setChecked(rideDTO.isBabyTransport());

                        builder.setView(dialogView);
                        builder.setBackground(getResources().getDrawable(R.drawable.rounded_dialog));
                        acceptRideDialog = builder.create();
                        acceptRideDialog.show();

                        final int totalProgressTime = 11;
                        final Thread thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                int jumpTime = 0;

                                while(jumpTime < totalProgressTime) {
                                    try {
                                        Thread.sleep(1000);
                                        jumpTime += 1;
                                        progressBar.setProgress(jumpTime);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                                acceptRideDialog.dismiss();

                            }
                        });
                        thread.start();


                    }
                    else
                    {}

                }

                @Override
                public void onFailure(Call<RideDTO> call, Throwable t) {
                    // handle error
                }
            }, prefs.getString("userId", ""));
            handler.postDelayed(runnable, 10000);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));




        driverMainViewModel = new DriverMainViewModel();

        setContentView(R.layout.activity_driver_main);

        mapView = findViewById(R.id.map_view);


        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(16);
        mapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));




        // acceptRideDialog.show();



        driverMainViewModel.getAllActiveVehicles().observe(this, list -> {

                    if (list != null) {
                        for (LocationDTO3 location : list) {
                            GeoPoint driverLocation = new GeoPoint(location.getLatitude(), location.getLongitude());
                            Marker driverMarker = new Marker(mapView);
                            driverMarker.setPosition(driverLocation);
                            driverMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                            driverMarker.setFlat(true);
                            driverMarker.setTitle("Driver");
                            driverMarker.setSubDescription("Standard");
                            mapView.getOverlays().add(driverMarker);
                            mapView.invalidate();
                        }
                    }

                }
        );

        String id = "1";


        driverMainViewModel.fetchActiveVehiclesLocation();

        handler.post(runnable);







        ImageView home = findViewById(R.id.home);
        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, DriverMainActivity.class));
//            }
//        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverMainActivity.this, DriverHistoryActivity.class));
                finish();

            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DriverMainActivity.this, DriverInboxActivity.class));
                finish();

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(DriverMainActivity.this, PassengerAccountActivity.class));
                Toast.makeText(DriverMainActivity.this, "TODO: Add driver account", Toast.LENGTH_SHORT).show();
                finish();

            }
        });




    }


    @Override
    protected void onStop() {
        super.onStop();
        handler.removeCallbacks(runnable);
    }
}