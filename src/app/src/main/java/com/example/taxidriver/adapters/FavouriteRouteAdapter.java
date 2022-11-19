package com.example.taxidriver.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.taxidriver.R;
import com.example.taxidriver.model.FavoriteRoute;

import java.util.ArrayList;

public class FavouriteRouteAdapter extends BaseAdapter {
    private Context context;
    public  ArrayList<FavoriteRoute> items;

    public FavouriteRouteAdapter(Context context, ArrayList<FavoriteRoute> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    public void removeItem(int index){
        items.remove(index);
        notifyDataSetChanged();
    }
    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        View view;
        FavoriteRoute fr = items.get(i);
        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.favorite_route_list, null);
        } else {
            view = convertView;
        }
        TextView from = (TextView) view.findViewById(R.id.from);
        TextView to = (TextView) view.findViewById(R.id.to);
        from.setText(String.format("Address: %d; %d", fr.getStartingPoint().getLatitude(), fr.getStartingPoint().getLongitude()));
        to.setText(String.format("Address: %d; %d", fr.getDestination().getLatitude(), fr.getDestination().getLongitude()));


        return view;
    }

}
