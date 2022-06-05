package com.System.PharmacyManagement.models;

import jdk.jfr.Enabled;

import javax.persistence.*;

@Entity
@Table(name = "drugStore")
public class DrugStore {
	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(
			name = "drugStore_sequence",
			sequenceName = "drugStore_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "drugStore_sequence"
	)
	private Long id;

	private String drugStoreID;
	private String drugSupplierID;
	private String name;
	private String address;

	public DrugStore() {
	}

public DrugStore(String drugStoreID, String drugSupplierID, String name, String address) {
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

	public void setDrugStoreID(String drugStoreID) {
		this.drugStoreID = drugStoreID;
	}

	public void setDrugSupplierID(String drugSupplierID) {
		this.drugSupplierID = drugSupplierID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDrugStoreID() {
	return drugStoreID;
}
public String getDrugSupplierID() {
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