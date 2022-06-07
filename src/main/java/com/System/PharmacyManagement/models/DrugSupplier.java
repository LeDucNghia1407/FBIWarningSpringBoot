package com.System.PharmacyManagement.models;



import javax.persistence.*;

@Entity
@Table(name = "drugSupplier")
public class DrugSupplier {




	@Id
	private String drugSupplierID;
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "address", nullable = false)
	private String address;

	public DrugSupplier() {
	}

	public DrugSupplier(String drugSupplierID, String name, String address) {
		this.drugSupplierID = drugSupplierID;
		this.name = name;
		this.address = address;
	}


	public String getDrugSupplierID() {
		return drugSupplierID;
	}

	public void setDrugSupplierID(String drugSupplierID) {
		this.drugSupplierID = drugSupplierID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString(){
		return "Drug Supplier{" + ", Drug Supplier: " + drugSupplierID + ", Name: " + name  + ", Address: " + address +"}";
	}

}
