package com.example.taxidriver.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.model.Cinema;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.model.Route;
import com.example.taxidriver.tools.Mockup;
import com.example.taxidriver.tools.Mokap;

import java.time.format.DateTimeFormatter;
import java.util.Locale;


public class HistoryAdapter extends BaseAdapter{

    private final Activity activity;

    public HistoryAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return Mockup.getDrives2().size();
    }
    @Override
    public Object getItem(int position) {
        return Mockup.getDrives2().get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Drive drive = Mockup.getDrives2().get(position);


        @SuppressLint("ViewHolder")
        View view = activity.getLayoutInflater().inflate(R.layout.history_list_element, null);

        TextView leftLocation = view.findViewById(R.id.leftLocation);
        TextView leftTime = view.findViewById(R.id.leftTime);
        TextView rightLocation = view.findViewById(R.id.rightLocation);
        TextView rightTime = view.findViewById(R.id.rightTime);

        Route route =  drive.getRoutes();


        leftLocation.setText(route.getStartPoint());
        rightLocation.setText(route.getEndPoint());

        leftTime.setText(drive.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm")));
        rightTime.setText(drive.getEndTime().format(DateTimeFormatter.ofPattern("hh:mm")));


        return view;
    }
}
