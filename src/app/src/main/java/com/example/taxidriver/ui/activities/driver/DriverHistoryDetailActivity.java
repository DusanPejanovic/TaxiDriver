package com.example.taxidriver.ui.activities.driver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import com.example.taxidriver.R;
import com.example.taxidriver.domain.viewmodel.RideHistoryDetailViewModel;
import com.example.taxidriver.ui.fragments.HistoryFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Polyline;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DriverHistoryDetailActivity extends AppCompatActivity {

     RideHistoryDetailViewModel rideHistoryDetailViewModel;
     String rideId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_history_detail);
        rideId = getIntent().getStringExtra("rideId");


        OkHttpClient client = new OkHttpClient();



        TextView cost = findViewById(R.id.cost);
        TextView pasengerEmail = findViewById(R.id.passengerEmail);
        TextView startTime = findViewById(R.id.startTime);
        TextView endTime = findViewById(R.id.endTime);
        TextView startPoint = findViewById(R.id.startPoint);
        TextView endPoint = findViewById(R.id.endPoint);
        TextView comment = findViewById(R.id.comment_detail);
        TextView grade = findViewById(R.id.grade_detail);
        MapView mapView = findViewById(R.id.map_view_detail);


        mapView.setTileSource(TileSourceFactory.MAPNIK);
        mapView.setBuiltInZoomControls(true);
        mapView.setMultiTouchControls(true);
        mapView.getController().setZoom(15);
        mapView.getController().setCenter(new GeoPoint(45.2396, 19.8227));

        rideHistoryDetailViewModel = new RideHistoryDetailViewModel();

        rideHistoryDetailViewModel.getRide().observe(this, rideDTO -> {


                    if(rideDTO != null)
                    {

                        int limit = 15;

                        String costText = rideDTO.getTotalCost().toString();
                        if (costText.length() > limit) {
                            costText = costText.substring(0, limit) + "...";
                        }
                        cost.setText(costText);

                        String passengerEmailText = rideDTO.getPassengerEmail();
                        if (passengerEmailText.length() > limit) {
                            passengerEmailText = passengerEmailText.substring(0, limit) + "...";
                        }
                        pasengerEmail.setText(passengerEmailText);

                        String startTimeText = rideDTO.getStartTime();
                        if (startTimeText.length() > limit) {
                            startTimeText = startTimeText.substring(0, limit) + "...";
                        }
                        startTime.setText(startTimeText);

                        String endTimeText = rideDTO.getEndTime();
                        if (endTimeText.length() > limit) {
                            endTimeText = endTimeText.substring(0, limit) + "...";
                        }
                        endTime.setText(endTimeText);

                        String startPointText = rideDTO.getStartPoint();
                        if (startPointText.length() > limit) {
                            startPointText = startPointText.substring(0, limit) + "...";
                        }
                        startPoint.setText(startPointText);

                        String endPointText = rideDTO.getEndPoint();
                        if (endPointText.length() > limit) {
                            endPointText = endPointText.substring(0, limit) + "...";
                        }
                        endPoint.setText(endPointText);

                        String commentText = rideDTO.getComment();
                        if (commentText.length() > limit) {
                            commentText = commentText.substring(0, limit) + "...";
                        }
                        comment.setText(commentText);

                        String gradeText = rideDTO.getGrade().toString();
                        if (gradeText.length() > limit) {
                            gradeText = gradeText.substring(0, limit) + "...";
                        }
                        grade.setText(gradeText);

                        String startLatitude = rideDTO.getCordinateStart().getLatitude().toString();
                        String startLongitude = rideDTO.getCordinateStart().getLongitude().toString();
                        String endLatitude= rideDTO.getCordinateEnd().getLatitude().toString();
                        String endLongitude = rideDTO.getCordinateEnd().getLongitude().toString();

                        String apiKey = "5b3ce3597851110001cf6248ef20a8142c654e9dba129cbcb06678f1";
                        String baseUrl = "https://api.openrouteservice.org/v2/directions/driving-car";
                        String requestUrl = baseUrl + "?api_key=" + apiKey + "&start=" + startLongitude + "," + startLatitude + "&end=" + endLongitude + "," + endLatitude;

                        Request request = new Request.Builder().url(requestUrl).build();
                        client.newCall(request).enqueue(new Callback() {
                            @Override
                            public void onFailure(@NonNull Call call, @NonNull IOException e) {

                            }

                            @Override
                            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                                String responseBody = response.body().string();
                                JSONObject jsonResponse = null;
                                JSONArray coordinates = null;
                                JSONObject coordinates1 = null;
                                try {
                                    jsonResponse = new JSONObject(responseBody);
                                    JSONArray routes = jsonResponse.getJSONArray("features");
                                    JSONObject route = routes.getJSONObject(0);
                                    coordinates1 = route.getJSONObject("geometry");
                                    coordinates = coordinates1.getJSONArray("coordinates");
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                                List<GeoPoint> routePoints = new ArrayList<>();
                                for (int i = 0; i < coordinates.length(); i++) {
                                    JSONArray point = null;
                                    double latitude = 0;
                                    double longitude = 0;

                                    try {
                                        point = coordinates.getJSONArray(i);

                                        latitude = point.getDouble(1);
                                        longitude = point.getDouble(0);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }


                                    routePoints.add(new GeoPoint(latitude, longitude));
                                }

                                // Draw the route on the map


                                Polyline roadOverlay = new Polyline();
                                roadOverlay.setPoints(routePoints);
                                roadOverlay.setColor(Color.BLACK);
                                roadOverlay.setWidth(8f);
                                mapView.getOverlays().add(roadOverlay);
                                mapView.invalidate();
                            }
                        });

                    }
                }
        );


        rideHistoryDetailViewModel.fetchRide(rideId);
/*


 */

    }
}