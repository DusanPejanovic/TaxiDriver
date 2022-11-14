package com.example.taxidriver.adapters;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.tools.Mockup;

import java.util.List;

public class RideHistoryAdapter extends BaseAdapter{

    private Activity activity;
    private List<Drive> drives;



    public RideHistoryAdapter(Activity activity, List<Drive> drives) {
        this.activity = activity;
        this.drives = drives;
    }



    @Override
    public int getCount() {
        return Mockup.getRides().size();
    }


    @Override
    public Object getItem(int position) {
        return Mockup.getRides().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        Drive drive = drives.get(position);

        if(convertView==null)
            vi = activity.getLayoutInflater().inflate(R.layout.drive_history_list_item, null);

        TextView name = (TextView)vi.findViewById(R.id.name);
        TextView description = (TextView)vi.findViewById(R.id.description);
        ImageView image = (ImageView)vi.findViewById(R.id.item_icon);

        name.setText(drive.getId());
        description.setText("id");

        return  vi;
    }
}
