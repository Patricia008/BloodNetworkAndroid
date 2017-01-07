package com.upt.cti.bloodnetwork.listadapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.upt.cti.bloodnetwork.R;
import com.upt.cti.bloodnetwork.listitemholders.PriorityItem;

import java.util.List;

/**
 * Created by Patry Carla on 1/4/2017.
 */

public class PriorityAdapter extends ArrayAdapter<PriorityItem> {
    private Context context;
    private List<PriorityItem> priorityItems;
    private int layoutResID;

    public PriorityAdapter(Context context, int layoutResourceID, List<PriorityItem> priorityItems) {
        super(context, layoutResourceID, priorityItems);
        this.context = context;
        this.priorityItems = priorityItems;
        this.layoutResID = layoutResourceID;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PriorityAdapter.ItemHolder itemHolder;
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            itemHolder = new PriorityAdapter.ItemHolder();

            view = inflater.inflate(layoutResID, parent, false);
            itemHolder.tName = (TextView) view.findViewById(R.id.tName);
            itemHolder.tQuantity = (TextView) view.findViewById(R.id.tQuantity);

            view.setTag(itemHolder);

        } else {
            itemHolder = (PriorityAdapter.ItemHolder) view.getTag();
        }

        final PriorityItem hItem = priorityItems.get(position);

        itemHolder.tName.setText(hItem.getName());
        itemHolder.tQuantity.setText(hItem.getAmount().toString());
        // itemHolder.tDate.setText("Date: " + hItem.timestamp.substring(0, 10));

        return view;
    }

    private static class ItemHolder {
        TextView tName;
        TextView tQuantity;
    }
}
