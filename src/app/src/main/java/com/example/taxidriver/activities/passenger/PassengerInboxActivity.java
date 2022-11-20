package com.example.taxidriver.activities.passenger;

import androidx.appcompat.app.AppCompatActivity;
import com.example.taxidriver.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import com.example.taxidriver.R;
import com.example.taxidriver.adapters.PassengerInboxAdapter;
import com.example.taxidriver.model.Message;
import com.example.taxidriver.tools.Mockup;

public class PassengerInboxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox_passenger);


        ImageView home = findViewById(R.id.home);
        ImageView history = findViewById(R.id.history);
        ImageView inbox = findViewById(R.id.inbox);
        ImageView profile = findViewById(R.id.profile);

        // Setup the data source
        ArrayList<Message> itemsArrayList = Mockup.getMessages(); // calls function to get items list

        // instantiate the custom list adapter
        PassengerInboxAdapter adapter = new PassengerInboxAdapter(this, itemsArrayList);

        // get the ListView and attach the adapter
        ListView itemsListView  = (ListView) findViewById(R.id.inbox_list);
        itemsListView.setAdapter(adapter);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerInboxActivity.this, PassengerMainActivity.class));
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(new Intent(PassengerMainActivity.this, PassengerHistoryFragment.class));
                Toast.makeText(PassengerInboxActivity.this, "TODO: Add passenger ride history", Toast.LENGTH_SHORT).show();
            }
        });
//        inbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(InboxActivityPassenger.this, InboxActivityPassenger.class));
//            }
//        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PassengerInboxActivity.this, PassengerAccountActivity.class));
            }
        });
    }
}