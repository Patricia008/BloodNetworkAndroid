package com.upt.cti.bloodnetwork.listitemholders;

/**
 * Created by Patry Carla on 1/4/2017.
 */

public class HistoryItem {

    public String date;
    public String amount;

    public HistoryItem(String date, String amount){
        this.date=date;
        this.amount=amount;
    }

    public String getDate() {
        return date;
    }

    public String getAmount() {
        return amount;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
