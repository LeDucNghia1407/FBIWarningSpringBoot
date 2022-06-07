package com.System.PharmacyManagement.models;



import javax.persistence.*;

@Entity
@Table(name = "drugStore")
public class DrugStore {



	@Id
	private String drugStoreID;
	@Column(name = "drugSupplierID", nullable = false)
	private String drugSupplierID;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "address", nullable = false)
	private String address;

	public DrugStore() {
	}

public DrugStore(String drugStoreID, String drugSupplierID, String name, String address) {
		this.drugStoreID = drugStoreID;
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
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
		return "Drug Store{ " + ", Drug Store ID: " + drugStoreID + ", Drug Supplier ID: " + drugSupplierID + ", Name: " + name + ", Address: " + address +"}";
	}

}