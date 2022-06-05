package com.System.PharmacyManagement.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Store")
public class Store {
    @Id
    @SequenceGenerator(
            name = "store_sequence",
            sequenceName = "store_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "store_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    private String storeID;
    private String drugID;
    private String drugStoreID;
    private String storeTime;
    private int quantity;

    public Store() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Store(String storeID, String drugID, String drugStoreID, String storeTime, int quantity) {
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

    public void setStoreTime(String storeTime) {
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
    public String getStoreTime(){
        return storeTime;
    }
    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString(){
        return "Manager{" + "Id: "+ id + ", Order ID: " + storeID +", Drug ID: "+ drugID+", Client ID: "+ drugStoreID+", Time: "+ storeTime+", Drug Quantity: "+ quantity+"}";
    }
}


