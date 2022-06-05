package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int managerID;
	private String drugStoreID;

	public Manager() {
	}

	public Manager(int managerID, String drugStoreID) {
		this.managerID = managerID;
		this.drugStoreID = drugStoreID;
	}

	public Long getId() {
		return id;
	}

public void setId(Long id) {
		this.id = id;
	}


public int getManagerID() {
	return managerID;
}
public String getDrugStoreID() {
	return drugStoreID;
}
	@Override
	public String toString(){
		return "Manager{" + "Id: "+ id + ", Manager: " + managerID +", Drug Store: "+ drugStoreID+"}";
	}
}
