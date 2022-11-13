package com.example.taxidriver;

import static android.widget.Toast.LENGTH_SHORT;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

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
        FragmentTransition.to(PassengerAccountProfile.newInstance(), this, false, R.id.mainContent);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}