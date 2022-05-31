package com.System.PharmacyManagement.models;

public class DrugStore {
	private int drugStoreID;
	private int drugSupplierID;
	private String name;
	private String address;

public DrugStore(int drugStoreID, int drugSupplierID, String name, String address) {
		this.drugStoreID = drugStoreID;
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
}

	public void setDrugStore(int drugStoreID, int drugSupplierID, String name, String address) {
		this.drugStoreID = drugStoreID;
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
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
}