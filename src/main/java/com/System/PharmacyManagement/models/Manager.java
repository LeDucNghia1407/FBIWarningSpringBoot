package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager {
	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(
			name = "manager_sequence",
			sequenceName = "manager_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "manager_sequence"
	)
	private Long id;

	private String managerID;
	private String drugStoreID;

	public Manager() {
	}

	public Manager(String managerID, String drugStoreID) {
		this.managerID = managerID;
		this.drugStoreID = drugStoreID;
	}

	public Long getId() {
		return id;
	}

public void setId(Long id) {
		this.id = id;
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
		return "Manager{" + "Id: "+ id + ", Manager: " + managerID +", Drug Store: "+ drugStoreID+"}";
	}
}
