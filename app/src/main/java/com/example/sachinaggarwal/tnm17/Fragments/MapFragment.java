package com.example.sachinaggarwal.tnm17.Fragments;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import com.example.sachinaggarwal.tnm17.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

/**
 * Created by HIman$hu on 2/19/2017.
 */

public class MapFragment extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private LocationManager locationManager;
    int currentapiVersion;
    private static final long MIN_TIME = 400;
    private static final float MIN_DISTANCE = 1000;
    final Activity activity=this;
    final int LOCATION_REQUEST_CONSTANT=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_map);
        currentapiVersion = android.os.Build.VERSION.SDK_INT;
        final String msg="Success";

        if(currentapiVersion>=23) {
            new AsyncTask<Void, Void, String>() {
                @Override
                protected String doInBackground(Void... params) {

//AIzaSyBk5fD48vYsnVJufeg-mYH6cehKc64U1Cw
                    if (ContextCompat.checkSelfPermission(activity,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(activity,
                                Manifest.permission.ACCESS_FINE_LOCATION)) {

                            // Show an expanation to the user *asynchronously* -- don't block
                            // this thread waiting for the user's response! After the user
                            // sees the explanation, try again to request the permission.

                        } else {

                            // No explanation needed, we can request the permission.

                            ActivityCompat.requestPermissions(activity,
                                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST_CONSTANT);

                            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                            // app-defined int constant. The callback method gets the
                            // result of the request.
                        }
                    }
                    return msg;
                }

                @Override
                protected void onPostExecute(String s) {
//                Log.d("Neo", "Neo");

                    start();

                }
            }.execute(null, null, null);

        }
        else
        {
            start();
        }
    }

    private Location getLastKnownLocation() {
        locationManager = (LocationManager) getApplicationContext().getSystemService(LOCATION_SERVICE);
        List<String> providers = locationManager.getProviders(true);
        Location bestLocation = null;
        Location l = new Location("dummy");
        for (String provider : providers) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                l = locationManager.getLastKnownLocation(provider);
            }
            if (l == null) {
                continue;
            }
            if (bestLocation == null || l.getAccuracy() < bestLocation.getAccuracy()) {
                // Found best last known location: %s", l);
                bestLocation = l;
            }
        }
        return bestLocation;
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        currentapiVersion = android.os.Build.VERSION.SDK_INT;
        Location myLocation = new Location("dummy");
        // Add a marker in Sydney and move the camera

        if(currentapiVersion<23) {
            try {
                mMap.setMyLocationEnabled(true);
            }
            catch (SecurityException e)
            {
                Log.d("Maps","Security error");
            }
        }


//        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        String provider = locationManager.getBestProvider(criteria, true);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            myLocation = getLastKnownLocation();
        }
//        LatLng me=new LatLng(myLocation.getLatitude(),myLocation.getLongitude());
        LatLng ece = new LatLng(28.719444, 77.066428);
        LatLng mae = new LatLng(28.719249, 77.066311);
//        LatLng srground = new LatLng(28.365923,75.587759);
        LatLng eee = new LatLng(28.719642, 77.066510);
        LatLng admin = new LatLng(28.719286, 77.065889);
        LatLng cse = new LatLng(28.719573, 77.065790);
        LatLng amul = new LatLng(28.719654, 77.065643);
        LatLng mait = new LatLng(28.719614, 77.066192);
        LatLng IT = new LatLng(28.719791, 77.066729);
        LatLng library = new LatLng(28.720590, 77.066619);
        LatLng downtowncafe = new LatLng(28.719928, 77.066819);
        LatLng wtf = new LatLng(28.719598, 77.065072);
        LatLng hostel = new LatLng(28.718601, 77.065914);
        LatLng block9 = new LatLng(28.718326, 77.066199);
        LatLng audi= new LatLng(28.718825, 77.065504);
        LatLng  canteen = new LatLng(28.718837, 77.065367);
        LatLng miniaudi = new LatLng(28.718990, 77.065300);
        LatLng basketball = new LatLng(28.719511, 77.067006);
        LatLng badminton= new LatLng(28.719475, 77.067225);


        CameraPosition cameraPosition = new CameraPosition.Builder().
                target(admin).
                tilt(60).
                zoom(17).
                bearing(0).
                build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        mMap.addMarker(new MarkerOptions().position(ece).title("ECE BLOCK").snippet("BLOCK-4"));
        mMap.addMarker(new MarkerOptions().position(mae).title("MAE BLOCK").snippet("BLOCK-2"));
        mMap.addMarker(new MarkerOptions().position(eee).title("EEE BLOCK").snippet("BLOCK-6"));
        mMap.addMarker(new MarkerOptions().position(admin).title("ADMIN BLOCK").snippet(""));
        mMap.addMarker(new MarkerOptions().position(cse).title("CSE BLOCK").snippet("BLOCK-1"));
        mMap.addMarker(new MarkerOptions().position(amul).title("AMUL CANTEEN"));
        mMap.addMarker(new MarkerOptions().position(mait).title("MAIT"));
        mMap.addMarker(new MarkerOptions().position(downtowncafe).title("Downtown café"));

        mMap.addMarker(new MarkerOptions().position(wtf).title("What's the Food"));
        mMap.addMarker(new MarkerOptions().position(hostel).title("Maharaja Agrasen Boys Hostel"));
        mMap.addMarker(new MarkerOptions().position(audi).title("MAIT Auditorium"));
        mMap.addMarker(new MarkerOptions().position(miniaudi).title("MAIT Mini Auditorium"));
        mMap.addMarker(new MarkerOptions().position(canteen).title("MAIT Canteen 1"));
        mMap.addMarker(new MarkerOptions().position(basketball).title("Basket Ball Court"));
        mMap.addMarker(new MarkerOptions().position(badminton).title("Badminton Court"));

        mMap.addMarker(new MarkerOptions().position(library).title("MAIT's Library"));
        mMap.addMarker(new MarkerOptions().position(IT).title("IT BLOCK").snippet("BLOCK-8"));


        mMap.addMarker(new MarkerOptions().position(block9).title("Fresher's Block ").snippet("BLOCK-9"));

//        mMap.addMarker(new MarkerOptions().position(me).title("You are here!").snippet("Consider yourself located"));
//        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
        mMap.setBuildingsEnabled(true);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case LOCATION_REQUEST_CONSTANT: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    try {
                        mMap.setMyLocationEnabled(true);
                    }
                    catch (SecurityException e)
                    {
                        Log.d("Maps","Security error");
                    }

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    finishActivity(0);
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }


    public void start()
    {
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //You can also use LocationManager.GPS_PROVIDER and LocationManager.PASSIVE_PROVIDER

    }

}

