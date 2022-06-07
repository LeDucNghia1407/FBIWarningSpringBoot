package com.System.PharmacyManagement.models;



import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Drug")
public class Drug {




	public Drug(){

	}

	@Id
	private String drugID;
	@Column(name = "drugSupplierID", nullable = false)
	private String drugsupplierID;
	@Column(name = "drugName", nullable = false)
	private String drugName;
	@Column(name = "manufacturingDate", nullable = false)
	private Date manufacturingDate;
	@Column(name = "expiredDate", nullable = false)
	private Date expiredDate;
	@Column(name = "type", nullable = false)
	private String type;
	@Column(name = "price", nullable = false)
	private float price;



	public Drug(String drugID, String drugsupplierID, String drugName, Date manufacturingDate, Date expiredDate, String type, float price) {
		this.drugID = drugID;
		this.drugsupplierID = drugsupplierID;
		this.drugName = drugName;
		this.manufacturingDate = manufacturingDate;
		this.expiredDate = expiredDate;
		this.type = type;
		this.price = price;
	}


	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}

	public void setDrugsupplierID(String drugsupplierID) {
		this.drugsupplierID = drugsupplierID;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public void setManufacturingDate(Date manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public void setExpiredDate(Date expiredDate) {
		this.expiredDate = expiredDate;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPrice(float price) {
		this.price = price;
	}

public String getDrugID() {
	return drugID;
}
public String getDrugSupplierID() {
	return drugsupplierID;
}
public String  getDrugName() {
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
		return "Drug{"  + ", Drug ID: " + drugID +", Drug SupplierID: "+ drugsupplierID +", Drug Name: "+ drugName +", Manufacturing Date: "+ manufacturingDate + ", Expired Date "+ expiredDate +", Type: "+ type +", Price "+ price +"}";
	}
}
