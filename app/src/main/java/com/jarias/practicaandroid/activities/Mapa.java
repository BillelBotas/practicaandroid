package com.jarias.practicaandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jarias.practicaandroid.R;
import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class Mapa extends AppCompatActivity implements OnMapReadyCallback, View.OnClickListener {

    private MapView mapView;
    private MapboxMap mapboxMap;
    private double latitud, longitud;
    private String nombre;
    private String descripcion;
    private FloatingActionButton fabAnadir, fabListado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MapboxAccountManager.start(this, "pk.eyJ1IjoiYmlsbGVsYm90YXMiLCJhIjoiY2pwdTZjMnRjMGNlZjQ0cDN1enNiZWVqeCJ9.QTJehKE4v8fchz6A7BBzNg");

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        descripcion = intent.getStringExtra("descripcion");
        latitud = intent.getDoubleExtra("latitud", 40.4167);
        longitud = intent.getDoubleExtra("longitud", -3.70325);

        setContentView(R.layout.activity_mapa);
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
        fabAnadir = (FloatingActionButton) findViewById(R.id.fabAnadir);
        fabAnadir.setOnClickListener(this);
        fabListado = (FloatingActionButton) findViewById(R.id.fabListado);
        fabListado.setOnClickListener(this);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;

        CameraPosition posicion = new CameraPosition.Builder()
                .target(new LatLng(latitud, longitud))
                .build();

        mapboxMap.animateCamera(CameraUpdateFactory.newCameraPosition(posicion), 7000);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case R.id.fabAnadir:
                intent = new Intent(this, Alta.class);
                startActivity(intent);
                break;
            case R.id.fabListado:
                intent = new Intent(this, Listado.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
