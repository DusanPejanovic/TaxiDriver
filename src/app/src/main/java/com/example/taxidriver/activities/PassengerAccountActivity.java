package com.example.taxidriver.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.taxidriver.R;
import com.example.taxidriver.fragments.PassengerAccountFavouriteRides;
import com.example.taxidriver.fragments.PassengerAccountProfile;
import com.example.taxidriver.tools.FragmentTransition;

//6. PassengerAccountActivity - omogućiti prikaz menija sa sledećim stavkama:
//        6.1. Nalog: pregled informacija o nalogu putnika i njihovo ažuriranje:
//        dodavanje profilne slike, izmena podataka o plaćanju, izmena osnovnih
//        informacija (ime, prezime, lokacija..)
//        6.2. Omiljene rute: prikaz omiljenih ruta od korisnika, odakle može da ponovo
//        izabere istu rutu za poručivanje odmah ili kasnije, kao i da je obriše iz
//        omiljenih.
//        6.3. Izveštaj: mogućnost generisanja izveštaja o prethodnim vožnjama za
//        definisan vremenski period. Na osnovu definisanog opsega datuma
//        prikaže se graf koji prikazuje broj vožnji po danima, broj pređenih
//        kilometara, količinu potrošenog novca za sopstvene vožnje. Uz te p

public class PassengerAccountActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger_account);
        FragmentTransition.to(PassengerAccountFavouriteRides.newInstance(), this, false, R.id.mainContent);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}