package com.System.PharmacyManagement.models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="Drug")
public class Drug {

	@Id
	@Column(name = "id", nullable = false)
	@SequenceGenerator(
			name = "drug_sequence",
			sequenceName = "drug_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "drug_sequence"
	)
	private Long id;

	public Drug(){

	}

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
public Long getId() {
		return id;
	}

public void setId(Long id) {
		this.id = id;
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
		return "Drug{" + "Id: "+ id + ", Drug ID: " + drugID +", Drug SupplierID: "+ drugsupplierID +", Drug Name: "+ drugName +", Manufacturing Date: "+ manufacturingDate + ", Expired Date "+ expiredDate +", Type: "+ type +", Price "+ price +"}";
	}
}
