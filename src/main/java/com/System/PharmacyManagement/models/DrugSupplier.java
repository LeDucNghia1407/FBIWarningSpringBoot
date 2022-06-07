package com.System.PharmacyManagement.models;


import javax.persistence.*;

@Entity
@Table(name = "drugSupplier")
public class DrugSupplier {
	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(
			name = "drugSupplier_sequence",
			sequenceName = "drugSupplier_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "drugSupplier_sequence"
	)
	private Long id;

	private String drugSupplierID;
	private String name;
	private String address;

	public DrugSupplier() {
	}

	public DrugSupplier(String drugSupplierID, String name, String address) {
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
		return "Drug Supplier{" + "Id: "+ id + ", Drug Supplier: " + drugSupplierID + ", Name: " + name  + ", Address: " + address +"}";
	}

}
