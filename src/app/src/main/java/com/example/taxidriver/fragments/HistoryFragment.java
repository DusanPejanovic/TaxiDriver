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
import com.example.taxidriver.adapters.HistoryAdapter;

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







}