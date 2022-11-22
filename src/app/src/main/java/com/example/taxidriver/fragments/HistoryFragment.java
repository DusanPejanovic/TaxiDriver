package com.example.taxidriver.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.taxidriver.R;
import com.example.taxidriver.activities.driver.DriverHistoryDetailActivity;
import com.example.taxidriver.adapters.HistoryAdapter;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.tools.Mockup;

import java.time.format.DateTimeFormatter;

public class HistoryFragment extends ListFragment {

	public static HistoryFragment newInstance() {
        return new HistoryFragment();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle data) {
		this.setListAdapter(new HistoryAdapter(this.getActivity()));


        View view = inflater.inflate(R.layout.history_list, viewGroup, false);

        return view;
	}

	@Override
	public void onListItemClick(@NonNull ListView listView, @NonNull View view, int position, long id) {
		super.onListItemClick(listView, view, position, id);

		Drive drive = Mockup.getDrives2().get(position);

		Intent intent = new Intent(this.getActivity(), DriverHistoryDetailActivity.class);


		intent.putExtra("cost", drive.getCost().toString());
		intent.putExtra("mileage", drive.getMileage().toString());

		intent.putExtra("startTime", drive.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm")));
		intent.putExtra("endTime", drive.getEndTime().format(DateTimeFormatter.ofPattern("hh:mm")));

		intent.putExtra("startPoint", drive.getRoutes().getStartPoint());
		intent.putExtra("endPoint", drive.getRoutes().getEndPoint());

		intent.putExtra("comment", drive.getReview().getComment());
		intent.putExtra("grade", drive.getReview().getGrade().toString());

		intent.putExtra("passenger", drive.getPassenger().getEmail());

		startActivity(intent);
	}






}