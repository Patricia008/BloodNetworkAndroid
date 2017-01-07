package com.upt.cti.bloodnetwork.listadapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.upt.cti.bloodnetwork.listitemholders.HistoryItem;
import com.upt.cti.bloodnetwork.R;

import java.util.List;

/**
 * Created by Patry Carla on 1/4/2017.
 */

public class HistoryAdapter extends ArrayAdapter<HistoryItem> {
    private Context context;
    private List<HistoryItem> historyItems;
    private int layoutResID;

    public HistoryAdapter(Context context, int layoutResourceID, List<HistoryItem> historyItems) {
        super(context, layoutResourceID, historyItems);
        this.context = context;
        this.historyItems = historyItems;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemHolder itemHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            itemHolder = new ItemHolder();

            view = inflater.inflate(layoutResID, parent, false);
            itemHolder.tDate = (TextView) view.findViewById(R.id.tDate);
            itemHolder.tQuantity = (TextView) view.findViewById(R.id.tQuantity);

            view.setTag(itemHolder);

        } else {
            itemHolder = (ItemHolder) view.getTag();
        }

        final HistoryItem hItem = historyItems.get(position);

        itemHolder.tDate.setText(hItem.getDate());
        itemHolder.tQuantity.setText(hItem.getAmount());
       // itemHolder.tDate.setText("Date: " + hItem.timestamp.substring(0, 10));

        return view;
    }

    private static class ItemHolder {
        TextView tDate;
        TextView tQuantity;
    }
}
