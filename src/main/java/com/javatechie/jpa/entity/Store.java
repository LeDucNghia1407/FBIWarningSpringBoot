package com.javatechie.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@ToString
@Entity
public class Store {

    @Id
    private String id;
    //@Column(nullable = false)
    private Date storeTime;
    private int drugQuantity;

    @ManyToOne
    @JoinColumn(name = "drugID", nullable = false)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "drugSupplierID", nullable = false)
    private DrugStore drugStore;

    public Store(String id, Date storeTime, int drugQuantity, Drug drug, DrugStore drugStore) {
        this.id = id;
        this.storeTime = storeTime;
        this.drugQuantity = drugQuantity;
        this.drug = drug;
        this.drugStore = drugStore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public int getDrugQuantity() {
        return drugQuantity;
    }

    public void setDrugQuantity(int drugQuantity) {
        this.drugQuantity = drugQuantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public DrugStore getDrugStore() {
        return drugStore;
    }

    public void setDrugStore(DrugStore drugStore) {
        this.drugStore = drugStore;
    }
}
