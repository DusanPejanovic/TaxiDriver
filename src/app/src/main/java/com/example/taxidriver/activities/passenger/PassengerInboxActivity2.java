package com.example.taxidriver.activities.passenger;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.taxidriver.R;
import com.example.taxidriver.fragments.HistoryFragment;
import com.example.taxidriver.fragments.InboxFragment2;

public class PassengerInboxActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_inbox2);


        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.mainContent2, InboxFragment2.newInstance()).commit();



    }
}