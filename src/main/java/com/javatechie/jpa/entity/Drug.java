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
public class Drug {
    @Id
    private String id;
    //@Column(nullable = false)
    private String drugName;
    //@Column(nullable = false)
    private Date manufacturingDate;
    //@Column(nullable = false)
    private Date expiredDate;
    //@Column(nullable = false)
    private String type;
    private int price;


    @ManyToOne
    @JoinColumn(name = "drugSupplierID", nullable = false)
    private DrugSupplier drugSupplier;


    @OneToMany(mappedBy = "id")
    private List<Orders> ordersList;

    @OneToMany(mappedBy = "id")
    private List<Store> storeList;

    public Drug(String id, String drugName, Date manufacturingDate, Date expiredDate, String type, int price, DrugSupplier drugSupplier) {
        this.id = id;
        this.drugName = drugName;
        this.manufacturingDate = manufacturingDate;
        this.expiredDate = expiredDate;
        this.type = type;
        this.price = price;
        this.drugSupplier = drugSupplier;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(Date expiredDate) {
        this.expiredDate = expiredDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DrugSupplier getDrugSupplier() {
        return drugSupplier;
    }

    public void setDrugSupplier(DrugSupplier drugSupplier) {
        this.drugSupplier = drugSupplier;
    }
}
