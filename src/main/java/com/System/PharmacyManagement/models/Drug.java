package com.System.PharmacyManagement.models;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name="Drug")
public class Drug {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private int drugID;
	private int drugsupplierID;
	private int drugName;
	private Date manufacturingDate;
	private Date expiredDate;
	private String type;
	private float price;


	public Drug() {
	}

	public Drug(int drugID, int drugsupplierID, int drugName, Date manufacturingDate, Date expiredDate, String type, float price) {
		this.drugID = drugID;
		this.drugsupplierID = drugsupplierID;
		this.drugName = drugName;
		this.manufacturingDate = manufacturingDate;
		this.expiredDate = expiredDate;
		this.type = type;
		this.price = price;
	}
public Long getId() {
		return id;
	}

public void setId(Long id) {
		this.id = id;
	}

public int getDrugID() {
	return drugID;
}
public int getDrugSupplierID() {
	return drugsupplierID;
}
public int  getDrugName() {
	return drugName;
}
public Date getManufacturingDate() {
	return manufacturingDate;
}
public Date getExpiredDate() {
	return expiredDate;
}
public String getType() {
	return type;
}
public float getPrice() {
	return price;
}

	@Override
	public String toString(){
		return "Drug{" + "Id: "+ id + ", Drug ID: " + drugID +", Drug SupplierID: "+ drugsupplierID +", Drug Name: "+ drugName +", Manufacturing Date: "+ manufacturingDate + ", Expired Date "+ expiredDate +", Type: "+ type +", Price "+ price +"}";
	}
}
