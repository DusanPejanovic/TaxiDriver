package com.example.taxidriver.ui.activities.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taxidriver.R;

import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;


public class DriverMainActivity extends AppCompatActivity {
    private boolean togleValue = false;
    private MapView mMapView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));


        setContentView(R.layout.activity_driver_main);
        final LinearLayout mapContainer = findViewById(R.id.map_container);

        //Mapa mora da se doda nakon onCreate aktivitija i onda ubaci u neki container
        mMapView = new MapView(this);
        mMapView.setTileSource(TileSourceFactory.MAPNIK);
        mapContainer.addView(this.mMapView);
        //TODO fix zoom
        mMapView.getController().setZoom(15);
        //Center novi sad
        mMapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));


        Button login_button = findViewById(R.id.online_ofline_button);
        TextView online_ofline_text_view = findViewById(R.id.online_ofline_text_view);

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

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(togleValue == false)
                {
                  online_ofline_text_view.setText("online");
                  togleValue = true;
                }
                else
                {
                    online_ofline_text_view.setText("offline");
                    togleValue = false;
                }


            }
        });



    }
}