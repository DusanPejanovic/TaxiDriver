package com.example.taxidriver.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.taxidriver.R;
import com.example.taxidriver.activities.passenger.PassengerMainActivity;
import com.example.taxidriver.adapters.FavouriteRouteAdapter;
import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.tools.Mockup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassengerAccountFavouriteRoutes#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassengerAccountFavouriteRoutes extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<FavoriteRoute> routes = new ArrayList<FavoriteRoute>();
    private ListView routesListView;


    public PassengerAccountFavouriteRoutes() {
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
    public static PassengerAccountFavouriteRoutes newInstance(String param1, String param2) {
        PassengerAccountFavouriteRoutes fragment = new PassengerAccountFavouriteRoutes();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static PassengerAccountFavouriteRoutes newInstance() {
        return new PassengerAccountFavouriteRoutes();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_passenger_account_favourite_routes, container, false);
        prepareList();
        routesListView = view.findViewById(R.id.fav_routes_listview);
        FavouriteRouteAdapter adapter = new FavouriteRouteAdapter(getActivity(), routes);
        routesListView.setOnItemClickListener(new RoutesItemsClickListener());
        routesListView.setAdapter(adapter);
        routesListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                builder.setMessage("Delete the chosen route?");
                builder.setCancelable(true);
                builder.setPositiveButton(
                        "Yes",
                        (dialog, id1) -> {
                            adapter.removeItem(i);
                            dialog.cancel();
                        });

                builder.setNegativeButton(
                        "No",
                        (dialog, id2) -> dialog.cancel());

                AlertDialog alert = builder.create();
                alert.show();
                return true;
            }
        });
        return view;
    }

    private class RoutesItemsClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//            ImageView delete = view.findViewById(R.id.delete_fav_route);
//            delete.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    Toast.makeText(getContext(), position, Toast.LENGTH_SHORT).show();
//                }
//            });
            AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
            builder.setMessage("Order an uber for the chosen route?");
            builder.setCancelable(true);
            builder.setPositiveButton(
                    "Yes",
                    (dialog, id1) -> {
                        Intent intent = new Intent(view.getContext(), PassengerMainActivity.class);
                        startActivity(intent);
                        dialog.cancel();
                    });

            builder.setNegativeButton(
                    "No",
                    (dialog, id2) -> dialog.cancel());

            AlertDialog alert = builder.create();
            alert.show();
        }


    }

    private void prepareList() {
        for (FavoriteRoute fr : Mockup.getFavoriteRoutes()) {
            routes.add(fr);
        }
    }
}