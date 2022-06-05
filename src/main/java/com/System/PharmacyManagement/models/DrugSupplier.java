package com.System.PharmacyManagement.models;


import javax.persistence.*;

@Entity
@Table(name = "drugSupplier")
public class DrugSupplier {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int drugSupplierID;
	private String name;
	private String address;

	public DrugSupplier() {
	}

	public DrugSupplier(int drugSupplierID, String name, String address) {
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
		return "Drug Supplier{" + "Id: "+ id + ", Drug Supplier: " + drugSupplierID + ", Name: " + name + ", Name: " + name + ", Address: " + address +"}";
	}

}
