package com.example.taxidriver.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.taxidriver.R;
import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.tools.Mockup;

public class FavouriteRouteAdapter extends BaseAdapter {
    private Activity activity;

    public FavouriteRouteAdapter(Activity activity) {
        this.activity = activity;
    }
    @Override
    public int getCount() {
        return Mockup.getFavoriteRoutes().size();
    }

    @Override
    public Object getItem(int i) {
        return Mockup.getFavoriteRoutes().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view = convertView;
        FavoriteRoute fr = Mockup.getFavoriteRoutes().get(i);
        if (convertView==null)
            view = activity.getLayoutInflater().inflate(R.layout.favorite_route_list, null);
        TextView from = (TextView)view.findViewById(R.id.from);
        TextView to = (TextView)view.findViewById(R.id.to);
        from.setText(String.format("%d; %d", fr.getStartingPoint().getLatitude(), fr.getStartingPoint().getLongitude()));
        to.setText(String.format("%d; %d", fr.getDestination().getLatitude(), fr.getDestination().getLongitude()));

        return view;
    }
}
