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
import com.example.taxidriver.tools.Mokap;


public class HistoryAdapter extends BaseAdapter{

    private final Activity activity;

    public HistoryAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return Mokap.getCinemas().size();
    }
    @Override
    public Object getItem(int position) {
        return Mokap.getCinemas().get(position);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Cinema cinema = Mokap.getCinemas().get(position);
        @SuppressLint("ViewHolder")
        View view = activity.getLayoutInflater().inflate(R.layout.history_list_element, null);

        TextView name = view.findViewById(R.id.name);
        TextView description = view.findViewById(R.id.description);
        ImageView image = view.findViewById(R.id.item_icon);

        name.setText(((Cinema) cinema).getName());
        description.setText(cinema.getDescription());
        // image.setImageResource(cinema.getAvatar());


        return view;
    }
}
