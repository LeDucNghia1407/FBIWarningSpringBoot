package com.System.PharmacyManagement.models;



import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Store")
public class Store {


    @Id
    private String storeID;
    @Column(name = "drugID", nullable = false)
    private String drugID;
    @Column(name = "drugStoreID", nullable = false)
    private String drugStoreID;
    @Column(name = "storeTime", nullable = false)
    private Date storeTime;
    @Column(name = "Quantity", nullable = false)
    private int quantity;

    public Store() {
    }



    public Store(String storeID, String drugID, String drugStoreID, Date storeTime, int quantity) {
        this.storeID = storeID;
        this.drugID = drugID;
        this.drugStoreID = drugStoreID;
        this.storeTime = storeTime;
        this.quantity = quantity;
    }

    public void setStoreID(String storeID) {
        this.storeID = storeID;
    }

    public void setDrugID(String drugID) {
        this.drugID = drugID;
    }

    public void setDrugStoreID(String drugStoreID) {
        this.drugStoreID = drugStoreID;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public void setQuantity(int quantity) {
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

    @Override
    public String toString(){
        return "Store {"+ ", Order ID: " + storeID +", Drug ID: "+ drugID+", Client ID: "+ drugStoreID+", Time: "+ storeTime+", Drug Quantity: "+ quantity+"}";
    }
}


