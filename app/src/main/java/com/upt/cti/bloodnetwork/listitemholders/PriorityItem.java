package com.upt.cti.bloodnetwork.listitemholders;

/**
 * Created by Patry Carla on 1/4/2017.
 */

public class PriorityItem {
    public String name;
    public Long amount;

    public PriorityItem(String name, Long amount){
        this.name =name;
        this.amount=amount;
    }

    public String getName() {
        return name;
    }

    public Long getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
