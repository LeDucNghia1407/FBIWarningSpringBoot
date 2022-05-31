package PMS;

import java.util.Date;

public class Drug {
	String drugID;
	String drugsupplierID;
	String drugName;
	Date manufacturingDate;
	Date expiredDate;
	String type;
	float price;

String getDrugID() {
	return drugID;
}
String getDrugSupplierID() {
	return drugsupplierID;
}
String  getDrugName() {
	return drugName;
}
Date getManufacturingDate() {
	return manufacturingDate;
}
Date getExpiredDate() {
	return expiredDate;
}
String getType() {
	return type;
}
float getPrice() {
	return price;
}
}
