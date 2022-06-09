package com.javatechie.jpa.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@Entity
public class Manager {

    @Id
    private String id;

    @OneToOne
    @JoinColumn(name = "id")
    private DrugStore drugStore;

    @OneToOne(mappedBy = "manager")
    private Employee employee;

    public Manager(String id, DrugStore drugStore) {
        this.id = id;
        this.drugStore = drugStore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DrugStore getDrugStore() {
        return drugStore;
    }

    public void setDrugStore(DrugStore drugStore) {
        this.drugStore = drugStore;
    }
}
