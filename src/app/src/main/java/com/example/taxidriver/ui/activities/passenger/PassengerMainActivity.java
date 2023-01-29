package com.example.taxidriver.ui.activities.passenger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Geocoder;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.dto.EstimationDTO;
import com.example.taxidriver.data.dto.EstimationRequestDTO2;
import com.example.taxidriver.data.dto.LocationDTO3;
import com.example.taxidriver.data.dto.ResetPasswordDTO;
import com.example.taxidriver.data.repository.UnregisteredUserRepository;
import com.example.taxidriver.domain.viewmodel.PassengerMainViewModel;
import com.example.taxidriver.domain.viewmodel.RideHistoryViewModel;
import com.example.taxidriver.ui.activities.LoginActivity;
import com.example.taxidriver.ui.activities.driver.DriverMainActivity;
import com.example.taxidriver.ui.fragments.HistoryFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.JsonObject;

import org.mapsforge.core.model.Point;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.Projection;
import org.osmdroid.views.overlay.ItemizedOverlay;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.OverlayItem;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// putnik u bazi pravi -> pennding ride

//


public class PassengerMainActivity extends AppCompatActivity {


    private MapView mapView;
    private EditText destinationEditText;
    private EditText departureEditText;
    private CheckBox petCheckBox;
    private CheckBox kidCheckBox;
    private Spinner vehicleTypeSpinner;
    private Button submitRideRequestButton;
    private UnregisteredUserRepository unregisteredUserRepository;
    private PassengerMainViewModel viewModel;


    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_main);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        viewModel = new ViewModelProvider(this).get(PassengerMainViewModel.class);

        unregisteredUserRepository = new UnregisteredUserRepository();

        // Find the elements in the layout by their ID
        destinationEditText = findViewById(R.id.destination);
        departureEditText = findViewById(R.id.departure);
        //timeEditText = findViewById(R.id.time);
        TimePicker timePicker = findViewById(R.id.time_picker);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        petCheckBox = findViewById(R.id.pet);
        vehicleTypeSpinner = findViewById(R.id.vehicle_type);
        kidCheckBox = findViewById(R.id.kid);
        submitRideRequestButton = findViewById(R.id.submit_ride_request);
        mapView = findViewById(R.id.map_view);


        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(16);
        mapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));

        MaterialAlertDialogBuilder builder1 = new MaterialAlertDialogBuilder(PassengerMainActivity.this);
        LayoutInflater inflater = PassengerMainActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.wait_driver_accept_ride_dialog, null);
        builder1.setView(dialogView);
        builder1.setBackground(getResources().getDrawable(R.drawable.rounded_dialog));
        final AlertDialog waitDriverDialog = builder1.create();




        submitRideRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer hour = timePicker.getHour();
                Integer minute = timePicker.getMinute();
                String departure  = departureEditText.getText().toString();
                String destination = destinationEditText.getText().toString();
                boolean isKid = kidCheckBox.isChecked();
                boolean isPet = petCheckBox.isChecked();
                String vehicleType = (String) vehicleTypeSpinner.getSelectedItem();

                EstimationRequestDTO2  estimationRequest = new EstimationRequestDTO2(departure,destination,isKid, isPet, vehicleType);

                if (hour < LocalDateTime.now().getHour() && minute < LocalDateTime.now().getMinute())
                {
                    Toast.makeText(TaxiDriver.getAppContext(), "Time must be in future.", Toast.LENGTH_SHORT).show();
                    return;
                }

                unregisteredUserRepository.getEstimation(new Callback<EstimationDTO>() {
                    @Override
                    public void onResponse(@NonNull Call<EstimationDTO> call, @NonNull Response<EstimationDTO> response) {
                        if (response.isSuccessful()) {

                            assert response.body() != null;

                            EstimationDTO estimation = response.body();
                            MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(PassengerMainActivity.this);
                            LayoutInflater inflater = PassengerMainActivity.this.getLayoutInflater();
                            View dialogView = inflater.inflate(R.layout.estimation_accept, null);
                            builder.setView(dialogView);
                            builder.setBackground(getResources().getDrawable(R.drawable.rounded_dialog));
                            final AlertDialog estimationDialog = builder.create();
                            TextView estimatedTime = dialogView.findViewById(R.id.estimated_time);
                            TextView estimatedCost = dialogView.findViewById(R.id.estimated_cost);

                            estimatedTime.setText("Estimated time: " + estimation.getEstimatedTimeInMinutes() + " minutes");
                            estimatedCost.setText("Estimated cost: " + estimation.getEstimatedCost() +  " $");
                            Button sendButton = dialogView.findViewById(R.id.accept_estimation_button);

                            sendButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    waitDriverDialog.show();
                                    estimationDialog.dismiss();


                        /*
                        String email = emailEditText.getText().toString();
                        if (!TextUtils.isEmpty(email)) {
                            userRepository.sendCode(new ResetPasswordDTO(email));
                            showResetPasswordDialog(email);
                            forgotPasswordDialog.dismiss();
                        } else {
                            Toast.makeText(TaxiDriver.getAppContext(), "Email field is empty.", Toast.LENGTH_SHORT).show();
                        }
                         */
                                }
                            });

                            estimationDialog.show();

                        } else {
                            Toast.makeText(TaxiDriver.getAppContext(), "Estimation response body invalid.", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<EstimationDTO> call, Throwable t) {
                        Toast.makeText(TaxiDriver.getAppContext(), "Address does not exist in Novi Sad.", Toast.LENGTH_SHORT).show();
                    }
                }, estimationRequest);



            }
        });

        viewModel.getAllActiveVehicles().observe(this, list -> {

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


        viewModel.fetchActiveVehiclesLocation();


        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(PassengerMainActivity.this, PassengerHistoryFragment.class));
                Toast.makeText(PassengerMainActivity.this, "TODO: Add passenger ride history", Toast.LENGTH_SHORT).show();
                finish();

            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerMainActivity.this, PassengerInboxActivity2.class));
                finish();

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerMainActivity.this, PassengerAccountActivity.class));
                finish();

            }
        });
    }
}

