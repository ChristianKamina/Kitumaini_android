package com.example.kitumaini_app;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.kitumaini_app.databinding.ActivityMapsBinding;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    RecyclerView list_maps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //list_maps = findViewById(R.id.list_maps);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
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
        final LatLng PPS1 = new LatLng(-4.3124453, 15.2723457);
        mMap.addMarker(new MarkerOptions().position(PPS1).title("PPS1").snippet("Information sur le lieu"));

        final LatLng PPS2 = new LatLng(-4.317219, 15.266352);
        mMap.addMarker(new MarkerOptions().position(PPS2).title("PPS2").snippet("Information sur le lieu"));

        final LatLng PPS3 = new LatLng(-4.3160849, 15.2717307);
        mMap.addMarker(new MarkerOptions().position(PPS3).title("PPS2").snippet("Information sur le lieu"));

        final LatLng PPS4 = new LatLng(-4.319267, 15.2708357);
        mMap.addMarker(new MarkerOptions().position(PPS4).title("PPS2").snippet("Information sur le lieu"));

        final LatLng PPS5 = new LatLng(-4.3216849, 15.2691664);
        mMap.addMarker(new MarkerOptions().position(PPS5).title("PPS5").snippet("Information sur le lieu"));

        final LatLng PPS6 = new LatLng(-4.3104607, 15.2722839);
        mMap.addMarker(new MarkerOptions().position(PPS6).title("PPS6").snippet("Information sur le lieu"));

        final LatLng PPS7 = new LatLng(-4.3133807, 15.2698562);
        mMap.addMarker(new MarkerOptions().position(PPS7).title("PPS7").snippet("Information sur le lieu"));

        final LatLng PPS8 = new LatLng(-4.3194175, 15.2719956);
        mMap.addMarker(new MarkerOptions().position(PPS8).title("PPS8").snippet("Information sur le lieu"));

        final LatLng PPS9 = new LatLng(-4.3264075, 15.2749543);
        mMap.addMarker(new MarkerOptions().position(PPS9).title("PPS9").snippet("Information sur le lieu"));

        final LatLng PPS10 = new LatLng(-4.3234572, 15.2864098);
        mMap.addMarker(new MarkerOptions().position(PPS10).title("PPS10").snippet("Information sur le lieu"));

        final LatLng PPS11 = new LatLng(-4.3174961, 15.2839822);
        mMap.addMarker(new MarkerOptions().position(PPS11).title("PPS11").snippet("Information sur le lieu"));

        final LatLng PPS12 = new LatLng(-4.3203274, 15.2921218);
        mMap.addMarker(new MarkerOptions().position(PPS12).title("PPS12").snippet("Information sur le lieu"));

        final LatLng PPS13 = new LatLng(-4.307346, 15.2834581);
        mMap.addMarker(new MarkerOptions().position(PPS13).title("PPS13").snippet("Information sur le lieu"));

        final LatLng PPS14 = new LatLng(-4.3064533, 15.2865837);
        mMap.addMarker(new MarkerOptions().position(PPS14).title("PPS14").snippet("Information sur le lieu"));

        final LatLng PPS15 = new LatLng(-4.3139626, 15.2744078);
        mMap.addMarker(new MarkerOptions().position(PPS15).title("PPS15").snippet("Information sur le lieu"));

        /*LatLng sydney = new LatLng(-43124453, 15,2723457);
        mMap.addMarker(new MarkerOptions().position(sydney).title("PPS1"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney)); */

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(PPS1, 10F));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else{
            mMap.setMyLocationEnabled(true);
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults){
        if (requestCode == 0){
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                mMap.setMyLocationEnabled(true);
            }
        }
    }
}