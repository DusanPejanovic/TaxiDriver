package com.example.taxidriver.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.taxidriver.R;
import com.example.taxidriver.model.FavoriteRoute;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassengerAccountFavouriteRides#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassengerAccountFavouriteRides extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<FavoriteRoute> rides = new ArrayList<FavoriteRoute>();
    private ListView ridesList;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PassengerAccountFavouriteRides() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PAssangerAccountFavouriteRides.
     */
    // TODO: Rename and change types and number of parameters
    public static PassengerAccountFavouriteRides newInstance(String param1, String param2) {
        PassengerAccountFavouriteRides fragment = new PassengerAccountFavouriteRides();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static PassengerAccountFavouriteRides newInstance(){
        return new PassengerAccountFavouriteRides();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_passenger_account_favourite_rides, container, false);
        return view;
    }
}