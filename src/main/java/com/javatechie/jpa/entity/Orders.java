package com.javatechie.jpa.entity;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Orders {

    @Id
    private String id;
    //@Column(nullable = false)
    private Date time;
    private int drugQuantity;

    @ManyToOne
    @JoinColumn(name = "drugID", nullable = false)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "clientID", nullable = false)
    private Client client;


    public Orders(String id, Date time, int drugQuantity, Drug drug, Client client) {
        this.id = id;
        this.time = time;
        this.drugQuantity = drugQuantity;
        this.drug = drug;
        this.client = client;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
