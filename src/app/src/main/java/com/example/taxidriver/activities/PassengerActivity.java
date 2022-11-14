package com.example.taxidriver.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.taxidriver.R;
import com.example.taxidriver.databinding.ActivityMainBinding;
import com.example.taxidriver.fragments.PassengerHistoryFragment;
import com.example.taxidriver.fragments.PassengerHomeFragment;
import com.example.taxidriver.fragments.PassengerSettingsFragment;


public class PassengerActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new PassengerHomeFragment());

        binding.bottomNavigationView_passenger.setOnItemSelectedListener(item -> {
            switch (item.getItemId()){

                case R.id.home:
                    replaceFragment(new PassengerHomeFragment());
                    break;
                case R.id.settings:
                    replaceFragment(new PassengerSettingsFragment());
                    break;
                case R.id.history:
                    replaceFragment(new PassengerHistoryFragment());
                    break;

            }

            return true;
        });

        
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmenTransaction = fragmentManager.beginTransaction();
        fragmenTransaction.replace(R.id.frame_layout_passenger, fragment);
        fragmenTransaction.commit();
    }
}