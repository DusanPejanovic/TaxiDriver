package com.example.taxidriver.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.ListFragment;

import com.example.taxidriver.R;
import com.example.taxidriver.activities.driver.DriverHistoryDetailActivity;
import com.example.taxidriver.adapters.HistoryAdapter;
import com.example.taxidriver.adapters.InboxAdapter2;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.tools.Mockup;

public class InboxFragment2 extends ListFragment {

	public static InboxFragment2 newInstance() {
        return new InboxFragment2();
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle data) {
		this.setListAdapter(new InboxAdapter2(this.getActivity()));


        View view = inflater.inflate(R.layout.inbox2_list, viewGroup, false);

        return view;
	}







}