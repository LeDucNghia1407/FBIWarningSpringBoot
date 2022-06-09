package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DrugSupplier {
    @Id
    private String id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private String address;


    @OneToMany(mappedBy = "id")
    private List<DrugStore> drugStoreList;

    @OneToMany(mappedBy = "id")
    private List<Drug> drugList;

    public DrugSupplier(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
