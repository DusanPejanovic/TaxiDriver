package com.example.taxidriver.ui.activities.passenger;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;

import com.example.taxidriver.R;
import com.example.taxidriver.data.dto.LocationDTO3;
import com.example.taxidriver.domain.viewmodel.PassengerMainViewModel;
import com.example.taxidriver.domain.viewmodel.RideHistoryViewModel;
import com.example.taxidriver.ui.fragments.HistoryFragment;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

public class PassengerMainActivity extends AppCompatActivity {


    private MapView mapView;
    private EditText destinationEditText;
    private EditText departureEditText;
    private CheckBox petCheckBox;
    private CheckBox kidCheckBox;
    private Button submitRideRequestButton;
    private PassengerMainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_main);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        viewModel = new ViewModelProvider(this).get(PassengerMainViewModel.class);


        // Find the elements in the layout by their ID
        destinationEditText = findViewById(R.id.destination);
        departureEditText = findViewById(R.id.departure);
        //timeEditText = findViewById(R.id.time);
        TimePicker timePicker = findViewById(R.id.time_picker);
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        petCheckBox = findViewById(R.id.pet);
        kidCheckBox = findViewById(R.id.kid);
        submitRideRequestButton = findViewById(R.id.submit_ride_request);
        mapView = findViewById(R.id.map_view);


        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(16);
        mapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));

        MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(PassengerMainActivity.this);
        LayoutInflater inflater = PassengerMainActivity.this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.wait_driver_accept_ride_dialog, null);
        builder.setView(dialogView);
        builder.setBackground(getResources().getDrawable(R.drawable.rounded_dialog));
        final AlertDialog waitDriverDialog = builder.create();





        submitRideRequestButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                waitDriverDialog.show();
                //final EditText emailEditText = dialogView.findViewById(R.id.email_edit_text);
                //Button sendButton = dialogView.findViewById(R.id.send_button);



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

