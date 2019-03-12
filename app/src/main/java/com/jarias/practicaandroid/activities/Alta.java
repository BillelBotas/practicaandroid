package com.jarias.practicaandroid.activities;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.jarias.practicaandroid.R;
import com.jarias.practicaandroid.base.Lugar;
import com.jarias.practicaandroid.spring.Subir;
import com.jarias.practicaandroid.util.Metodos;
import com.mapbox.mapboxsdk.MapboxAccountManager;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;

public class Alta extends Activity implements MapboxMap.OnMapClickListener, OnMapReadyCallback ,View.OnClickListener {

    private MapView mapView;
    private MapboxMap mapboxMap;
    private Lugar lugar;
    private MarkerOptions marker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        Button btnAnadir = findViewById(R.id.btnAnadir);
        btnAnadir.setOnClickListener(this);
        Button btnCanecelar = findViewById(R.id.btnCancelar);
        btnCanecelar.setOnClickListener(this);

        MapboxAccountManager.start(this, "pk.eyJ1IjoiYmlsbGVsYm90YXMiLCJhIjoiY2pwdTZjMnRjMGNlZjQ0cDN1enNiZWVqeCJ9.QTJehKE4v8fchz6A7BBzNg");
        mapView = (MapView) findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnadir:
                EditText etNombre = findViewById(R.id.etNombre);
                EditText etDescripcion = findViewById(R.id.etDescripcion);

                lugar = new Lugar();
                lugar.setNombre(etNombre.getText().toString());
                lugar.setDescripcion(etDescripcion.getText().toString());
                lugar.setLatitud(marker.getPosition().getLatitude());
                lugar.setLongitud(marker.getPosition().getLongitude());
                /*Subir subir = new Subir();
                subir.execute(lugar.getNombre(), lugar.getDescripcion(), String.valueOf(lugar.getLatitud()), String.valueOf(lugar.getLongitud()));*/
                break;
            case R.id.btnCancelar:
                onBackPressed();
                break;
            default:
                break;
        }

    }

    @Override
    public void onMapClick(@NonNull LatLng point) {
        mapboxMap.clear();
        marker = new MarkerOptions().setPosition(point);
        mapboxMap.addMarker(marker);
    }

    @Override
    public void onMapReady(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        mapboxMap.setOnMapClickListener(this);
    }
}
