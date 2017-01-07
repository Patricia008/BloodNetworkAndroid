package com.upt.cti.bloodnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.upt.cti.bloodnetwork.listadapters.HistoryAdapter;
import com.upt.cti.bloodnetwork.listitemholders.HistoryItem;

import java.util.ArrayList;
import java.util.List;

public class History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        List<HistoryItem> history = new ArrayList<>();
        history.add(new HistoryItem("3.5.2016","400ml"));
        history.add(new HistoryItem("30.7.2016","100ml"));
        history.add(new HistoryItem("4.9.2016","300ml"));



        ListView listHistory = (ListView) findViewById(R.id.listHistory);
        final HistoryAdapter adapter = new HistoryAdapter(this, R.layout.item_history, history);
        listHistory.setAdapter(adapter);
//        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, history);
//        listPayments.setAdapter(listAdapter);
    }
}
