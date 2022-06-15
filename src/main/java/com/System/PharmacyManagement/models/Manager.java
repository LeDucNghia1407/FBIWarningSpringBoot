package com.System.PharmacyManagement.models;



import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
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
    private long id;

    @OneToOne
    @JoinColumn(name = "DrugStoreID", nullable = true)
    private DrugStore drugStore;
    public Manager() {}
    public Manager(long id, DrugStore drugStore) {
        this.id = id;
        this.drugStore = drugStore;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public DrugStore getDrugStore() {
        return drugStore;
    }

    public void setDrugStore(DrugStore drugStore) {
        this.drugStore = drugStore;
    }
}
