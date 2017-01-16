package com.upt.cti.bloodnetwork;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.upt.cti.bloodnetwork.persistence.domain.dto.UserDTO;
import com.upt.cti.bloodnetwork.serviceHandlers.ServiceCaller;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class SignIn extends AppCompatActivity {

    private ServiceCaller serviceCaller;

    public static UserDTO user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        serviceCaller = new ServiceCaller();
    }

    public void clicked(View view) {
        final Intent intent;
        switch (view.getId()) {
            case R.id.signup:
                intent = new Intent(this, SignUp.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                final String email = (((EditText)findViewById(R.id.input_email)).getText().toString());
                intent = new Intent(this, Menu.class);
                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try  {
                            String url = serviceCaller.host+"user/find/"+email;
                            Looper.prepare();
                            RestTemplate restTemplate = new RestTemplate();
                            restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                            UserDTO result = restTemplate.getForObject(url, UserDTO.class);
                            if(result != null){
                                user=result;
                                startActivity(intent);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                thread.start();
                break;
        }
    }

    public UserDTO getUser(){
        return user;
    }
}
