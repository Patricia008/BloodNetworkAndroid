package com.upt.cti.bloodnetwork.serviceHandlers;

import android.os.Looper;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Patry Carla on 1/8/2017.
 */

public class ServiceCaller {

    public String host = "http://192.168.2.32:8080/bloodnetwork/api/";

    public void callPostService(final String url, final Object entity){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    Looper.prepare();
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
                    String result = restTemplate.postForObject(url, entity, String.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }


}
