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
public class Orders {

    @Id
    @SequenceGenerator(
            name = "orders_sequence",
            sequenceName = "orders_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "orders_sequence"
    )
    @Column(name = "id", nullable = false)
    private long id;
    //@Column(nullable = false)
    private Date time;
    private int drugQuantity;

    @ManyToOne
    @JoinColumn(name = "drugID", nullable = true)
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "clientID", nullable = true)
    private Client client;


    public Orders(long id, Date time, int drugQuantity, Drug drug, Client client) {
        this.id = id;
        this.time = time;
        this.drugQuantity = drugQuantity;
        this.drug = drug;
        this.client = client;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
