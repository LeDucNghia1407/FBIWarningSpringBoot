package com.System.PharmacyManagement.models;

public class Manager {
	private String managerID;
	private String drugStoreID;

public Manager(String managerID, String drugStoreID) {
		this.managerID = managerID;
		this.drugStoreID = drugStoreID;
}

	public void setManager(String managerID, String drugStoreID) {
		this.managerID = managerID;
		this.drugStoreID = drugStoreID;
	}


public String getManagerID() {
	return managerID;
}
public String getDrugStoreID() {
	return drugStoreID;
}
}
