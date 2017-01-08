package com.upt.cti.bloodnetwork;


import android.content.Context;
import android.icu.text.DateFormat;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.serviceHandlers.ServiceCaller;

import java.text.ParseException;
import java.sql.Date;

public class Donation extends AppCompatActivity {

    private ServiceCaller serviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation);
        serviceCaller = new ServiceCaller();
    }

    public void clicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                final String date = (((EditText)findViewById(R.id.input_date)).getText().toString());
                final String amount = (((EditText)findViewById(R.id.input_amount)).getText().toString());
                final String place = (((EditText)findViewById(R.id.input_place)).getText().toString());

                DonationDTO donation = new DonationDTO();
                DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
                Date startDate = null;
                try {
                    startDate = (Date)formatter.parse(date);
                    donation.setDate(startDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }

                donation.setQuantity(new Long(amount));
                donation.setPlaceId(new Long(place));

                serviceCaller.callPostService(serviceCaller.host+"donation/create",donation);

                Context context = getApplicationContext();
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, "Your donation has been registered", duration);
                toast.show();

                break;
        }
    }

}
