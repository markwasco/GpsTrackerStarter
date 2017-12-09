package com.blinkymap.gpslocationlist;

import android.Manifest;
import android.location.Geocoder;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.blinkymap.gpslocationlist.adapters.LatLongAdapter;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Button getLocationButton;
    RecyclerView gpsLocations;
    private Set<String> mLocations;
    private double mLatitude;
    private double mLongitude;
    Geocoder geocoder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLocations = new HashSet<>();
        getLocationButton = (Button) findViewById(R.id.getLocationButton);
        gpsLocations = (RecyclerView) findViewById(R.id.gpsLocationsRecyclerView);

        ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION},123);



        getLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GPSTracker gpsTracker = new GPSTracker(getApplicationContext());
                Location location = gpsTracker.getLocation();
                if(location !=null){
                    mLatitude = location.getLatitude();
                    mLongitude = location.getLongitude();
                    Toast.makeText(getApplicationContext(), "Latitude: "+ mLatitude +"\nLongitude: " + mLongitude,
                            Toast.LENGTH_LONG).show();
                    mLocations.add("Latitude: " + mLatitude +"\nLongitude: " + mLongitude);

                    LatLongAdapter adapter = new LatLongAdapter(mLocations.toArray(new String[0]));
                    gpsLocations.setAdapter(adapter);

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                    gpsLocations.setLayoutManager(layoutManager);

                    gpsLocations.setHasFixedSize(false);

                }
            }
        });



    }
}
