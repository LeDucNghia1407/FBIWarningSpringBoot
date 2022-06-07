package com.System.PharmacyManagement.models;



import javax.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager {



	@Id
	private String managerID;
	@Column(name = "drugStoreID", nullable = false)
	private String drugStoreID;

	public Manager() {
	}

	public Manager(String managerID, String drugStoreID) {
		this.managerID = managerID;
		this.drugStoreID = drugStoreID;
	}



	public void setManagerID(String managerID) {
		this.managerID = managerID;
	}

	public void setDrugStoreID(String drugStoreID) {
		this.drugStoreID = drugStoreID;
	}

	public String getManagerID() {
	return managerID;
}
public String getDrugStoreID() {
	return drugStoreID;
}
	@Override
	public String toString(){
		return "Manager{" + ", Manager: " + managerID +", Drug Store: "+ drugStoreID+"}";
	}
}
