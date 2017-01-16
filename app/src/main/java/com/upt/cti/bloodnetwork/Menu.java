package com.upt.cti.bloodnetwork;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.upt.cti.bloodnetwork.serviceHandlers.ServiceCaller;

import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

public class Menu extends AppCompatActivity {

    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;
    static public Date eventDate;
    private ServiceCaller serviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        serviceCaller = new ServiceCaller();

        eventDate = getNextDonationDate();

        initUI();
        countDownStart();
    }

    public Date getNextDonationDate(){
        SignIn signIn = new SignIn();
        final String email = signIn.getUser().getEmail();
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    String url = serviceCaller.host+"donation/next/"+email;
                    Looper.prepare();
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());
                    Date result = restTemplate.getForObject(url, Date.class);
                    if(result != null){
                        Menu.eventDate = result;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try{
        thread.join();}
        catch(InterruptedException e){
            e.printStackTrace();
        }
        return Menu.eventDate;
    }

    private void initUI() {
        linearLayout1 = (LinearLayout) findViewById(R.id.ll1);
        linearLayout2 = (LinearLayout) findViewById(R.id.ll2);
        tvDay = (TextView) findViewById(R.id.txtTimerDay);
        tvHour = (TextView) findViewById(R.id.txtTimerHour);
        tvMinute = (TextView) findViewById(R.id.txtTimerMinute);
        tvSecond = (TextView) findViewById(R.id.txtTimerSecond);
        tvEvent = (TextView) findViewById(R.id.tvevent);
    }

    // //////////////COUNT DOWN START/////////////////////////
    public void countDownStart() {
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                handler.postDelayed(this, 1000);
                try {
                    Date eventDate = Menu.eventDate;
                    Date currentDate = new Date();
                    if (!currentDate.after(eventDate)) {
                        long diff = eventDate.getTime()
                                - currentDate.getTime();
                        long days = diff / (24 * 60 * 60 * 1000);
                        diff -= days * (24 * 60 * 60 * 1000);
                        long hours = diff / (60 * 60 * 1000);
                        diff -= hours * (60 * 60 * 1000);
                        long minutes = diff / (60 * 1000);
                        diff -= minutes * (60 * 1000);
                        long seconds = diff / 1000;
                        tvDay.setText("" + String.format("%02d", days));
                        tvHour.setText("" + String.format("%02d", hours));
                        tvMinute.setText("" + String.format("%02d", minutes));
                        tvSecond.setText("" + String.format("%02d", seconds));
                    } else {
                        linearLayout1.setVisibility(View.VISIBLE);
                        linearLayout2.setVisibility(View.GONE);
                        tvEvent.setText("You can donate!");
                        handler.removeCallbacks(runnable);
                        // handler.removeMessages(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        handler.postDelayed(runnable, 0);
    }


    public void clicked(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.nearest:
                intent = new Intent(this, Nearest.class);
                startActivity(intent);
                break;
            case R.id.priority:
                intent = new Intent(this, Priority.class);
                startActivity(intent);
                break;
            case R.id.history:
                intent = new Intent(this, History.class);
                startActivity(intent);
                break;
            case R.id.donation:
                intent = new Intent(this, Donation.class);
                startActivity(intent);
                break;
        }
    }
}
