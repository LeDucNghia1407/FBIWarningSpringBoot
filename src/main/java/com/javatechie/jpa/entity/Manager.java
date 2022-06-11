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
    @SequenceGenerator(
            name = "manager_sequence",
            sequenceName = "manager_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "manager_sequence"
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne
    @JoinColumn(name = "DrugStoreID", nullable = true)
    private DrugStore drugStore;



    public Manager(Long id, DrugStore drugStore) {
        this.id = id;
        this.drugStore = drugStore;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DrugStore getDrugStore() {
        return drugStore;
    }

    public void setDrugStore(DrugStore drugStore) {
        this.drugStore = drugStore;
    }
}
