package com.javatechie.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import java.sql.Date;


@Data
@NoArgsConstructor
@ToString
@Entity
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
    private long id;
    //@Column(nullable = false)
    private Date storeTime;
    private int drugQuantity;

    @ManyToOne
    @JoinColumn(name = "drugID", nullable = true)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "drugStoreID", nullable = true)
    private DrugStore drugStore;

    public Store(long id, Date storeTime, int drugQuantity, Drug drug, DrugStore drugStore) {
        this.id = id;
        this.storeTime = storeTime;
        this.drugQuantity = drugQuantity;
        this.drug = drug;
        this.drugStore = drugStore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
