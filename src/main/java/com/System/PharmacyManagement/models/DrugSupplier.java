package com.System.PharmacyManagement.models;

public class DrugSupplier {
	private String drugSupplierID;
	private String name;
	private String address;

public DrugSupplier(String drugSupplierID, String name, String address) {
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
}
	public void setDrugSupplier(String drugSupplierID, String name, String address) {
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
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
}
