package com.upt.cti.bloodnetwork;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.upt.cti.bloodnetwork.serviceHandlers.ServiceCaller;
import com.upt.cti.bloodnetwork.serviceHandlers.dtos.LatLongDTO;
import com.upt.cti.bloodnetwork.serviceHandlers.dtos.UserDTO;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import static com.upt.cti.bloodnetwork.R.string.host;

public class SignUp extends AppCompatActivity {

    ServiceCaller serviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        serviceCaller = new ServiceCaller();
    }

    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btn_signup:

                UserDTO userDTO = new UserDTO();

                userDTO.setEmail(((EditText)findViewById(R.id.input_email)).getText().toString());
                userDTO.setPassword(((EditText)findViewById(R.id.input_password)).getText().toString());
                userDTO.setName(((EditText)findViewById(R.id.input_name)).getText().toString());
                String lat = (((EditText)findViewById(R.id.input_lat)).getText().toString());
                String longi = (((EditText)findViewById(R.id.input_long)).getText().toString());

                LatLongDTO latLongDTO = new LatLongDTO();
                latLongDTO.setLatitude(lat);
                latLongDTO.setLongitude(longi);

                userDTO.setLocation(latLongDTO);

                userDTO.setBloodType(((EditText)findViewById(R.id.input_blood)).getText().toString());
                userDTO.setWeight(((EditText)findViewById(R.id.input_weight)).getText().toString());

                serviceCaller.callPostService(serviceCaller.host+"user/create",userDTO);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "You can sign in now with your new user", duration);
                toast.show();
                intent = new Intent(this, SignIn.class);
                startActivity(intent);
                break;
        }
    }
}
