package com.example.taxidriver.ui.activities.driver;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.taxidriver.R;

public class DriverHistoryDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_history_detail);



        TextView cost = findViewById(R.id.cost);
        TextView mileage = findViewById(R.id.mileage);

        TextView startTime = findViewById(R.id.startTime);
        TextView endTime = findViewById(R.id.endTime);

        TextView startPoint = findViewById(R.id.startPoint);
        TextView endPoint = findViewById(R.id.endPoint);

        TextView comment = findViewById(R.id.comment);
        TextView grade = findViewById(R.id.grade);

        TextView passenger = findViewById(R.id.pasenger);

        cost.setText(getIntent().getStringExtra("cost") + " rsd");
        mileage.setText(getIntent().getStringExtra("mileage") + " km");

        startTime.setText(getIntent().getStringExtra("startTime"));
        endTime.setText(getIntent().getStringExtra("endTime"));

        startPoint.setText(getIntent().getStringExtra("startPoint"));
        endPoint.setText(getIntent().getStringExtra("endPoint"));

        comment.setText(getIntent().getStringExtra("comment"));
        grade.setText(getIntent().getStringExtra("grade"));

        passenger.setText(getIntent().getStringExtra("passenger"));

    }
}