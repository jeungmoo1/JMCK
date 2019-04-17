package com.example.jmck;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private static final int REQUEST_CODE_PERMISSIONS = 1000;
    private GoogleMap mMap;
    private GoogleApiClient mGoogleApiClient;
    private FusedLocationProviderClient mFusedLocationClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(36.833043   , 127.135606);
        mMap.addMarker(new MarkerOptions().position(sydney).title("천안 러브토이샵"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng ss = new LatLng(36.818696  , 127.132886);
        mMap.addMarker(new MarkerOptions().position(ss).title("천안 리틀킹콩"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ss));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng aa = new LatLng(36.352249  , 127.354924);
        mMap.addMarker(new MarkerOptions().position(aa).title("대전 위고토이"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(aa));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng bb = new LatLng(37.534520  , 126.992340);
        mMap.addMarker(new MarkerOptions().position(bb).title("이태원 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(bb));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng cc = new LatLng(37.559479  , 126.925105);
        mMap.addMarker(new MarkerOptions().position(cc).title("홍대점 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cc));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng dd = new LatLng(37.539743  , 127.127789);
        mMap.addMarker(new MarkerOptions().position(dd).title("강동 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(dd));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng ee = new LatLng(37.250177 , 127.634891);
        mMap.addMarker(new MarkerOptions().position(ee).title("여주아울렛 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ee));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng ff = new LatLng(35.868853 , 128.595385);
        mMap.addMarker(new MarkerOptions().position(ff).title("대구 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(ff));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        LatLng gg = new LatLng(37.264834 , 127.030217);
        mMap.addMarker(new MarkerOptions().position(gg).title("수원인계동 레드컨테이너"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(gg));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(14.0f));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:01030118929"));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });

        mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            // Use default InfoWindow frame
            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            // Defines the contents of the InfoWindow
            @Override
            public View getInfoContents(Marker arg0) {

                // Getting view from the layout file info_window_layout
                View v = getLayoutInflater().inflate(R.layout.info_window, null);

//                // Getting the position from the marker
//                LatLng latLng = arg0.getPosition();
//
//                // Getting reference to the TextView to set latitude
//                TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);
//
//                // Getting reference to the TextView to set longitude
//                TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);
//
//                // Setting the latitude
//                tvLat.setText("Latitude:" + latLng.latitude);
//
//                // Setting the longitude
//                tvLng.setText("Longitude:"+ latLng.longitude);

                // Returning the view containing InfoWindow contents
                return v;

            }
        });

    }

    public void onLastLocationButtonClicked(View view) {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
                    REQUEST_CODE_PERMISSIONS);
            return;
        }
        mFusedLocationClient.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location !=null){
                    LatLng myaLocation = new LatLng(location.getLatitude(), location.getLongitude());
                    mMap.addMarker(new MarkerOptions()
                            .position(myaLocation)
                            .title("현재 위치"));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(myaLocation));
                mMap.animateCamera(CameraUpdateFactory.zoomTo(17.0f));
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQUEST_CODE_PERMISSIONS:
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "권한 체크 거부 됨",Toast.LENGTH_SHORT).show();
                }
        }
    }
}

