package com.jarias.practicaandroid.spring;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.jarias.practicaandroid.adapters.AdapterLugar;
import com.jarias.practicaandroid.base.Lugar;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cargar extends AsyncTask<String, Integer, Void> {

    private AdapterLugar adapterLugar;
    private List<String> arrayAdapterLugar;
    private List<Lugar> lugares;


    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(String... strings) {
        lugares = new ArrayList<>();
        arrayAdapterLugar = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        Lugar[] lugaresArray = restTemplate.getForObject("http://10.0.2.2:8082" + "/lugares", Lugar[].class);
        lugares.addAll(Arrays.asList(lugaresArray));
        for (Lugar lugar : lugares) {
            arrayAdapterLugar.add(lugar.getNombre());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        adapterLugar.notifyDataSetChanged();
    }

}
