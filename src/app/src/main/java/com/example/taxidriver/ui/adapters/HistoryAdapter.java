package com.example.taxidriver.ui.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.data.dto.RideDTO;

import java.util.List;


public class HistoryAdapter extends BaseAdapter{

    private final Activity activity;
    private final List<RideDTO> rideDTOList;


    public HistoryAdapter(Activity activity, List<RideDTO> rideDTOList) {
        this.rideDTOList = rideDTOList;
        this.activity = activity;
    }



    @Override
    public int getCount() {
        return rideDTOList.size();
    }
    @Override
    public Object getItem(int position) {
        return rideDTOList.get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        RideDTO ride = rideDTOList.get(position);


        @SuppressLint("ViewHolder")
        View view = activity.getLayoutInflater().inflate(R.layout.history_list_element, null);

        TextView leftLocation = view.findViewById(R.id.leftLocation);
        TextView leftTime = view.findViewById(R.id.leftTime);
        TextView rightLocation = view.findViewById(R.id.rightLocation);
        TextView rightTime = view.findViewById(R.id.rightTime);

        leftLocation.setText(ride.getLocations().getDeparture().getAddress());
        rightLocation.setText(ride.getLocations().getDestination().getAddress());

        leftTime.setText(ride.getStartTime());
        rightTime.setText(ride.getEndTime());

        return view;
    }
}
