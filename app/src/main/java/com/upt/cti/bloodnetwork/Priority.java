package com.upt.cti.bloodnetwork;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.upt.cti.bloodnetwork.listadapters.HistoryAdapter;
import com.upt.cti.bloodnetwork.listadapters.PriorityAdapter;
import com.upt.cti.bloodnetwork.listitemholders.PriorityItem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("Since15")
public class Priority extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_priority);
        List<PriorityItem> centers = new ArrayList<>();
        centers.add(new PriorityItem("Regina Maria",4000L));
        centers.add(new PriorityItem("Sf. Stefan",6000L));
        centers.add(new PriorityItem("Spitalul Municipal",100000L));

        ListView listCenters = (ListView) findViewById(R.id.listCenters);

        centers.sort(new Comparator<PriorityItem>() {
            @Override
            public int compare(PriorityItem priorityItem, PriorityItem t1) {
                return (int) (t1.getAmount()-priorityItem.getAmount());
            }
        });

        final PriorityAdapter adapter = new PriorityAdapter(this, R.layout.item_priority, centers);
        listCenters.setAdapter(adapter);
//        centers.add("10.25");
//        centers.remove(2);
//// update UI
//        listAdapter.notifyDataSetChanged();
    }

}
