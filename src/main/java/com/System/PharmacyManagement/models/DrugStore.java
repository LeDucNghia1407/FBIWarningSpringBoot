package com.System.PharmacyManagement.models;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "drugStore")
public class DrugStore {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int drugStoreID;
	private int drugSupplierID;
	private String name;
	private String address;

	public DrugStore() {
	}

public DrugStore(int drugStoreID, int drugSupplierID, String name, String address) {
		this.drugStoreID = drugStoreID;
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
}

public Long getId() {
		return id;
}

public void setId(Long id) {
		this.id = id;
}

public int getDrugStoreID() {
	return drugStoreID;
}
public int getDrugSupplierID() {
	return drugSupplierID;
}
public String getName() {
	return name;
}
public String getAddress() {
	return address;
}

@Override
	public String toString(){
		return "Drug Store{" + "Id: "+ id + ", Drug Store ID: " + drugStoreID + ", Drug Supplier ID: " + drugSupplierID + ", Name: " + name + ", Address: " + address +"}";
	}

}