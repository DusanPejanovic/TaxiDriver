package com.example.taxidriver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.taxidriver.R;


public class DriverMainActivity extends AppCompatActivity {
    private boolean togleValue = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);


        Button login_button = findViewById(R.id.online_ofline_button);
        TextView online_ofline_text_view = findViewById(R.id.online_ofline_text_view);

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