package com.javatechie.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DrugStore {
    @Id
    private String id;
    //@Column(nullable = false)
    private String name;
    //@Column(nullable = false)
    private Date address;


    @ManyToOne
    @JoinColumn(name = "drugSupplierID",nullable = false)
    private DrugSupplier drugSupplier;


    @OneToMany(mappedBy = "id")
    private List<Employee> employeeList;

    @OneToMany(mappedBy = "id")
    private List<Store> storeList;

    @OneToOne(mappedBy = "drugStore")
    private Manager manager;


    public DrugStore(String id, String name, Date address, DrugSupplier drugSupplier) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.drugSupplier = drugSupplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAddress() {
        return address;
    }

    public void setAddress(Date address) {
        this.address = address;
    }

    public DrugSupplier getDrugSupplier() {
        return drugSupplier;
    }

    public void setDrugSupplier(DrugSupplier drugSupplier) {
        this.drugSupplier = drugSupplier;
    }
}
