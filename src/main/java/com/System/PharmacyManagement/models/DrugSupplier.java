package com.System.PharmacyManagement.models;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Data
@NoArgsConstructor
@ToString
@Entity
public class DrugSupplier {
    @Id
    @Column(name = "id", nullable = false)
    @SequenceGenerator(
            name = "drugSupplier_sequence",
            sequenceName = "drugSupplier_sequence",
            allocationSize = 1 //increment by 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator =  "drugSupplier_sequence"
    )
    private long id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String address;



    public DrugSupplier(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
