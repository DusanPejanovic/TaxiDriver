package com.example.taxidriver.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import com.example.taxidriver.R;
import com.example.taxidriver.activities.DetailActivity;
import com.example.taxidriver.adapters.RideHistoryAdapter;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.tools.Mockup;

import java.util.List;

public class MyFragment extends ListFragment {


    private List<Drive> drives;
    private ListView listView;

	public static MyFragment newInstance() {
        return new MyFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle data) {

        View view = inflater.inflate(R.layout.map_layout, vg, false);

/*

        listView = view.findViewById(R.id.list);

        drives = Mockup.getRides();

        RideHistoryAdapter adapter = new RideHistoryAdapter(getActivity(), drives);
        setListAdapter(adapter);

*/
        return view;
	}

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Drive drive = Mockup.getRides().get(position);

        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("name", drive.getId());
        intent.putExtra("descr", "id");
        startActivity(intent);
    }


}