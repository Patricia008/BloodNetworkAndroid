package com.upt.cti.bloodnetwork;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.upt.cti.bloodnetwork.listadapters.HistoryAdapter;
import com.upt.cti.bloodnetwork.listadapters.PriorityAdapter;
import com.upt.cti.bloodnetwork.listitemholders.HistoryItem;
import com.upt.cti.bloodnetwork.listitemholders.PriorityItem;
import com.upt.cti.bloodnetwork.persistence.domain.dto.BloodRequirementDTO;
import com.upt.cti.bloodnetwork.persistence.domain.dto.DonationDTO;
import com.upt.cti.bloodnetwork.serviceHandlers.ServiceCaller;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class History extends AppCompatActivity {

    private TextView tvDay, tvHour, tvMinute, tvSecond, tvEvent;
    private LinearLayout linearLayout1, linearLayout2;
    private Handler handler;
    private Runnable runnable;
    private ServiceCaller serviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        serviceCaller = new ServiceCaller();
//        List<HistoryItem> history = new ArrayList<>();
//        history.add(new HistoryItem("3.5.2016","400ml"));
//        history.add(new HistoryItem("30.7.2016","100ml"));
//        history.add(new HistoryItem("4.9.2016","300ml"));

        final History that = this;
        SignIn signin = new SignIn();
        final String email = signin.user.getEmail();

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    String url = serviceCaller.host+"donation/find/"+email;
                    Looper.prepare();
                    RestTemplate restTemplate = new RestTemplate();
                    restTemplate.getMessageConverters().add(new StringHttpMessageConverter());

                    ResponseEntity<List<DonationDTO>> rateResponse =
                            restTemplate.exchange(url,
                                    HttpMethod.GET, null, new ParameterizedTypeReference<List<DonationDTO>>() {
                                    });
                    List<DonationDTO> result = rateResponse.getBody();

                    if(result!=null){
                        List<HistoryItem> histories = convertDTOToListItemHistory(result);
                        ListView listHistories = (ListView) findViewById(R.id.listHistory);

                        final HistoryAdapter adapter = new HistoryAdapter(that, R.layout.item_history, histories);
                        listHistories.setAdapter(adapter);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        initUI();
        countDownStart();

//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, history);
//        listPayments.setAdapter(listAdapter);
    }

    private List<HistoryItem> convertDTOToListItemHistory(List<DonationDTO> donations){
        List<HistoryItem> historyItems = new ArrayList<>();
        for(DonationDTO br : donations){
            HistoryItem pi = new HistoryItem(br.getDate().toString(), Long.toString(br.getQuantity()));
            historyItems.add(pi);
        }
        return historyItems;
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
                    SimpleDateFormat dateFormat = new SimpleDateFormat(
                            "yyyy-MM-dd");
                    // Here Set your Event Date
                    Menu menu = new Menu();
                    Date eventDate = dateFormat.parse(menu.eventDate);
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
}
