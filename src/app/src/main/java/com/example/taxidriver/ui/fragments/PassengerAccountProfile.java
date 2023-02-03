package com.example.taxidriver.ui.fragments;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.taxidriver.R;
import com.example.taxidriver.TaxiDriver;
import com.example.taxidriver.data.dto.IsInRideDTO;
import com.example.taxidriver.data.dto.PassengerDTO;
import com.example.taxidriver.data.dto.RideDTO4;
import com.example.taxidriver.data.repository.PassengerRepository;
import com.example.taxidriver.domain.model.Passenger;
import com.example.taxidriver.util.Mockup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

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
    PassengerRepository passengerRepository = new PassengerRepository();
    SharedPreferences prefs = TaxiDriver.getAppContext().getSharedPreferences("prefs", Context.MODE_PRIVATE);

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
    private void fillPassengerInfo(View view){
        passengerRepository.getPassengerDetails(new retrofit2.Callback<PassengerDTO>() {
            @Override
            public void onResponse(Call<PassengerDTO> call, Response<PassengerDTO> response) {
                if (response.isSuccessful()) {
                    PassengerDTO passenger = response.body();
                    EditText name = (EditText) view.findViewById(R.id.nameInput);
                    name.setText(passenger.getName());
                    EditText surname = (EditText)view.findViewById(R.id.surnameInput);
                    surname.setText(passenger.getSurname());
                    EditText address = (EditText) view.findViewById(R.id.addressInput);
                    address.setText(passenger.getAddress());
                    EditText phoneNum = (EditText)view.findViewById(R.id.phoneNumberInput);
                    phoneNum.setText(passenger.getTelephoneNumber());
                    EditText email = (EditText)view.findViewById(R.id.emailInput);
                    email.setText(passenger.getEmail());


                } else {

                    Toast.makeText(TaxiDriver.getAppContext(), "Ne valja repo", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<PassengerDTO> call, Throwable t) {

            }
        }, prefs.getString("userId", null));


    }

    private void changePassengerInfo(View view){
        PassengerDTO passenger = new PassengerDTO();
        EditText name = (EditText) view.findViewById(R.id.nameInput);
        passenger.setName(name.getText().toString());
        EditText surname = (EditText)view.findViewById(R.id.surnameInput);
        passenger.setSurname(surname.getText().toString());
        EditText address = (EditText) view.findViewById(R.id.addressInput);
        passenger.setAddress(address.getText().toString());
        EditText phoneNum = (EditText)view.findViewById(R.id.phoneNumberInput);
        passenger.setTelephoneNumber(phoneNum.getText().toString());
        EditText email = (EditText)view.findViewById(R.id.emailInput);
        passenger.setEmail(email.getText().toString());
        passenger.setProfilePicture("profile.png");
        passengerRepository.putPassengerDetails(new retrofit2.Callback<PassengerDTO>() {
            @Override
            public void onResponse(Call<PassengerDTO> call, Response<PassengerDTO> response) {
                if (response.isSuccessful()) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setMessage("Change successful!");
                    AlertDialog dialog = builder.create();
                    dialog.show();

                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    try {
                        builder.setMessage(response.errorBody().string())
                                .setTitle("Error");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }

            @Override
            public void onFailure(Call<PassengerDTO> call, Throwable t) {

            }
        }, prefs.getString("userId", null), passenger);

    }
    private boolean validateForms(View view){
        EditText name = (EditText) view.findViewById(R.id.nameInput);
        EditText surname = (EditText)view.findViewById(R.id.surnameInput);
        EditText address = (EditText) view.findViewById(R.id.addressInput);
        EditText phoneNum = (EditText)view.findViewById(R.id.phoneNumberInput);
        EditText email = (EditText)view.findViewById(R.id.emailInput);
        ArrayList<EditText> fieldsNonEmpty = new ArrayList<EditText>(Arrays.asList(name, surname, address, phoneNum, phoneNum));
        final String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        final String phoneNumberPattern = "^(?:(?:\\+|0{0,2})91(\\s*[\\-]\\s*)?|[0]?)?[789]\\d{9}$";
//        if (!phoneNum.getText().toString().matches(phoneNumberPattern)) {
//            phoneNum.setError("Invalid email address");
//            return false;
//        } else {
//            phoneNum.setError(null);
//        }
        if (!email.getText().toString().matches(emailPattern)) {
            email.setError("Invalid email address");
            return false;
        } else {
            email.setError(null);
        }
        boolean isEmpty = false;
        for (EditText field: fieldsNonEmpty) {
            if (TextUtils.isEmpty(field.getText())) {
                field.setError("Cannot be empty");
                isEmpty = true;
            } else {
                field.setError(null);
            }
        }

        return !isEmpty;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_passenger_account_profile, container, false);
        fillPassengerInfo(view);
        Button confirm_changes  = view.findViewById(R.id.confirm_button);
        confirm_changes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view1) {
                if (!validateForms(view)){
                    return;
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(view1.getContext());
                builder.setMessage("Confirm changes?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        (dialog, id1) -> {
                            changePassengerInfo(view);
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

}