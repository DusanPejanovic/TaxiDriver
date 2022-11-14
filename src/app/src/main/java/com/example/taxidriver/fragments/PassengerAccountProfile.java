package com.example.taxidriver.fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.model.Passenger;
import com.example.taxidriver.tools.FragmentTransition;
import com.example.taxidriver.tools.Mockup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassengerAccountProfile#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassengerAccountProfile extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PassengerAccountProfile() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PassengerAccount.
     */
    // TODO: Rename and change types and number of parameters
    public static PassengerAccountProfile newInstance(String param1, String param2) {
        PassengerAccountProfile fragment = new PassengerAccountProfile();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }
    public static PassengerAccountProfile newInstance(){
        return new PassengerAccountProfile();
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
        View view =  inflater.inflate(R.layout.fragment_passenger_account_profile, container, false);
        mockupPassenger(view);
        Button confirm_changes  = view.findViewById(R.id.confirm_button);
        confirm_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Confirm changes?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        (dialog, id1) -> {
                            dialog.cancel();
                        });

                builder.setNegativeButton(
                        "No",
                        (dialog, id2) -> dialog.cancel());

                AlertDialog alert = builder.create();
                alert.show();
            }
        });
        return view;
    }
    public static void mockupPassenger(View view){
        Passenger passenger = Mockup.getPassenger();
        EditText name = (EditText) view.findViewById(R.id.nameInput);
        name.setText(passenger.getName());
        EditText surname = (EditText)view.findViewById(R.id.surnameInput);
        surname.setText(passenger.getLastname());
        EditText address = (EditText) view.findViewById(R.id.addressInput);
        address.setText(passenger.getAdress());
        EditText phoneNum = (EditText)view.findViewById(R.id.phoneNumberInput);
        phoneNum.setText(passenger.getPhoneNumber());
        EditText email = (EditText)view.findViewById(R.id.emailInput);
        email.setText(passenger.getEmail());

    }
}