package com.System.PharmacyManagement.models;

import java.util.Date;

public class Drug {
	private String drugID;
	private String drugsupplierID;
	private String drugName;
	private Date manufacturingDate;
	private Date expiredDate;
	private String type;
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
	public void setDrug(String drugID, String drugsupplierID, String drugName, Date manufacturingDate, Date expiredDate, String type, float price) {
		this.drugID = drugID;
		this.drugsupplierID = drugsupplierID;
		this.drugName = drugName;
		this.manufacturingDate = manufacturingDate;
		this.expiredDate = expiredDate;
		this.type = type;
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
}
