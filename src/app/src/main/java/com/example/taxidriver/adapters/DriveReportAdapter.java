package com.example.taxidriver.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.taxidriver.model.Drive;

import java.util.ArrayList;

public class DriveAdapter  extends BaseAdapter {
    private Context context;
    public ArrayList<Drive> items;

    public DriveAdapter(Context context, ArrayList<Drive> items) {
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

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
