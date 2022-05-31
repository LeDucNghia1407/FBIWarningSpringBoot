package com.System.PharmacyManagement.models;

import java.util.Date;

public class Store {
    private String storeID;
    private String drugID;
    private String drugStoreID;
    private Date storeTime;
    private int quantity;

    public Store(String storeID, String drugID, String drugStoreID, Date storeTime, int quantity) {
        this.storeID = storeID;
        this.drugID = drugID;
        this.drugStoreID = drugStoreID;
        this.storeTime = storeTime;
        this.quantity = quantity;
    }
    public void setStore(String storeID, String drugID, String drugStoreID, Date storeTime, int quantity) {
        this.storeID = storeID;
        this.drugID = drugID;
        this.drugStoreID = drugStoreID;
        this.storeTime = storeTime;
        this.quantity = quantity;
    }

    public String getStoreID(){
        return storeID;
    }
    public String getdrugID(){
        return drugID;
    }
    public String getdrugStoreID(){
        return drugStoreID;
    }
    public Date getStoreTime(){
        return storeTime;
    }
    public int getQuantity(){
        return quantity;
    }
}


