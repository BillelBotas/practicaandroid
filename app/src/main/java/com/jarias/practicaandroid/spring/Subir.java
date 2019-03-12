package com.jarias.practicaandroid.spring;

import android.os.AsyncTask;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Subir extends AsyncTask<String, Integer, Void> {
    @Override
    protected Void doInBackground(String... strings) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.getForObject("http://10.0.2.2:8082" + "/lugares?nombre=" + strings[0] + "&descripcion=" + strings[1] + "&latitud=" + strings[2] + "&longitud=" + strings[3], Void.class);
        return null;
    }
}
