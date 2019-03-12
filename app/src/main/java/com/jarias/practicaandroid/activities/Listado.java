package com.jarias.practicaandroid.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jarias.practicaandroid.R;
import com.jarias.practicaandroid.adapters.AdapterLugar;
import com.jarias.practicaandroid.base.Lugar;
import com.jarias.practicaandroid.spring.Cargar;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Listado extends Activity {

    private List<Lugar> lugares;
    private AdapterLugar adapterLugar;
    private int posicion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ListView lvListado = findViewById(R.id.lvListado);
        adapterLugar = new AdapterLugar(this, R.layout.item_lugar, lugares);
        lvListado.setAdapter(adapterLugar);

        /*Cargar cargar = new Cargar();
        cargar.execute();*/
    }
}