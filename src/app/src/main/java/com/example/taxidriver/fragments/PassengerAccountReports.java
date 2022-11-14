package com.example.taxidriver.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.adapters.DriveReportAdapter;
import com.example.taxidriver.adapters.FavouriteRouteAdapter;
import com.example.taxidriver.model.Drive;
import com.example.taxidriver.model.DriveReport;
import com.example.taxidriver.model.FavoriteRoute;
import com.example.taxidriver.tools.Mockup;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PassengerAccountReports#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PassengerAccountReports extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private ArrayList<DriveReport> items;
    private ListView driveReportsListView;
    int ridesSum = 0;
    int kmSum = 0;
    int moneySum = 0;
    double averageRides = 0;
    LocalDateTime fromDate;
    LocalDateTime toDate;
    double averageKm = 0;
    double averageMoney = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PassengerAccountReports() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PassengerAccountReports.
     */
    // TODO: Rename and change types and number of parameters
    public static PassengerAccountReports newInstance(String param1, String param2) {
        PassengerAccountReports fragment = new PassengerAccountReports();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public static Fragment newInstance() {
        return new PassengerAccountReports();
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
//        T
//        ArrayList<DriveReport> items = getReportRides(LocalDateTime.of(2022, 11, 14, 0, 0), LocalDateTime.of(2022, 11, 19, 0, 0));
        View view = inflater.inflate(R.layout.fragment_passenger_account_reports, container, false);
        driveReportsListView = view.findViewById(R.id.listViewReport);
//        items = getReportRides(LocalDateTime.now(), LocalDateTime.now().plusWeeks(1));
        items = new ArrayList<DriveReport>();
        DriveReportAdapter adapter = new DriveReportAdapter(getActivity(), items);
        driveReportsListView.setAdapter(adapter);
        CalendarView from = view.findViewById(R.id.dateStarting);
        CalendarView to = view.findViewById(R.id.dateEnding);

        from.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                fromDate = LocalDateTime.of(year, month + 1, day, 0, 0);
                if(toDate != null){
                    if (fromDate.isBefore(toDate) && toDate != null) {
                        TextView totalRides = view.findViewById(R.id.totalRides);
                        TextView totalKm = view.findViewById(R.id.totalKm);
                        TextView totalMoney = view.findViewById(R.id.totalSpent);
                        TextView averageRidesText = view.findViewById(R.id.averageRides);
                        TextView averageKmText = view.findViewById(R.id.averageKm);
                        TextView averageMoneyText = view.findViewById(R.id.averageSpent);

                        items = getReportRides(fromDate, toDate);
                        adapter.items = items;
                        adapter.notifyDataSetChanged();
                        totalRides.setText(String.valueOf(ridesSum));
                        totalKm.setText(String.valueOf(kmSum));
                        totalMoney.setText(String.valueOf(moneySum));
                        averageRidesText.setText(String.valueOf(averageRides));
                        averageKmText.setText(String.valueOf(averageKm));
                        averageMoneyText.setText(String.valueOf(averageMoney));



                    }
                }

            }
        });
        to.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                toDate = LocalDateTime.of(year, month + 1, day, 0, 0);
                if (fromDate != null){
                    if (fromDate.isBefore(toDate)) {
                        TextView totalRides = view.findViewById(R.id.totalRides);
                        TextView totalKm = view.findViewById(R.id.totalKm);
                        TextView totalMoney = view.findViewById(R.id.totalSpent);
                        TextView averageRidesText = view.findViewById(R.id.averageRides);
                        TextView averageKmText = view.findViewById(R.id.averageKm);
                        TextView averageMoneyText = view.findViewById(R.id.averageSpent);

                        items = getReportRides(fromDate, toDate);
                        adapter.items = items;
                        adapter.notifyDataSetChanged();
                        totalRides.setText(String.valueOf(ridesSum));
                        totalKm.setText(String.valueOf(kmSum));
                        totalMoney.setText(String.valueOf(moneySum));
                        averageRidesText.setText(String.valueOf(averageRides));
                        averageKmText.setText(String.valueOf(averageKm));
                        averageMoneyText.setText(String.valueOf(averageMoney));

                        adapter.notifyDataSetChanged();
                    }
                }
                }

        });
        adapter.notifyDataSetChanged();
        return view;
    }
    public class dateChangeListener implements  CalendarView.OnDateChangeListener{
        @Override
        public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {

        }
    }

    public ArrayList<DriveReport> getReportRides(LocalDateTime from, LocalDateTime to) {
        ArrayList<DriveReport> reports = new ArrayList<DriveReport>();
        ArrayList<Drive> drives = Mockup.getRides();
        ridesSum = 0;
        kmSum = 0;
        moneySum = 0;
        int i = 0;
        for (LocalDateTime date = from; date.isBefore(to); date = date.plusDays(1)) {
            DriveReport dr = new DriveReport(date, 0, 0, 0);
            while (i < drives.size()) {
                if (date.toLocalDate().equals(drives.get(i).getBeginTime().toLocalDate())) {
                    dr.rides += 1;
                    ridesSum += 1;
                    dr.mileage += drives.get(i).getMileage();
                    kmSum += drives.get(i).getMileage();
                    dr.spent += drives.get(i).getCost();
                    moneySum += drives.get(i).getCost();
                    i++;
                } else {
                    if(reports.isEmpty()){
                        i++;
                        if (i == drives.size()){
                            i = 0;
                            break;
                        }
                    }

                    else
                        break;
                }

            }
            reports.add(dr);
        }
        DecimalFormat format = new DecimalFormat("#.00");
        averageRides = Double.parseDouble(format.format((double) ridesSum / reports.size()));
        averageKm = Double.parseDouble(format.format((double) kmSum / reports.size()));
        averageMoney =  Double.parseDouble(format.format((double) moneySum / reports.size()));


        items = reports;

        return reports;
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}