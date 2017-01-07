package com.upt.cti.bloodnetwork.serviceHandlers;

import android.os.Looper;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Patry Carla on 1/8/2017.
 */

public class ServiceCaller {

    public String host = "IP_SERVER:8080/bloodnetwork/api/";

    public void callPostService(final String url, final Object entity){
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    Looper.prepare();
                    RestTemplate restTemplate = new RestTemplate();
                    //restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                    String result = restTemplate.postForObject(url, entity, String.class);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

}
