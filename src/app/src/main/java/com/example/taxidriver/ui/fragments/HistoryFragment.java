package com.example.taxidriver.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import com.example.taxidriver.R;
import com.example.taxidriver.data.dto.RideDTO;
import com.example.taxidriver.ui.activities.driver.DriverHistoryDetailActivity;
import com.example.taxidriver.ui.adapters.HistoryAdapter;
import com.example.taxidriver.domain.model.Drive;
import com.example.taxidriver.util.Mockup;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class HistoryFragment extends ListFragment {

	private List<RideDTO> rideDTOList;

	public static HistoryFragment newInstance(List<RideDTO> rideDTOList) {

		HistoryFragment historyFragment = new HistoryFragment();
		historyFragment.setRideDTOList(rideDTOList);
		return historyFragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle data) {

		this.setListAdapter(new HistoryAdapter(this.getActivity(), rideDTOList));

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

	public List<RideDTO> getRideDTOList() {
		return rideDTOList;
	}

	public void setRideDTOList(List<RideDTO> rideDTOList) {
		this.rideDTOList = rideDTOList;
	}
}