package com.System.PharmacyManagement.models;

import java.util.*;

public class Order {
	private String orderID;
	private String drugID;
	private String clientID;
	private Date time;
	private int drugQuantity;

public Order(String orderID, String drugID, String clientID, Date time, int drugQuantity) {
		this.orderID = orderID;
		this.clientID = clientID;
		this.drugID = drugID;
		this.time = time;
		this.drugQuantity = drugQuantity;
}

	public void setOrder(String orderID, String drugID, String clientID, Date time, int drugQuantity) {
		this.orderID = orderID;
		this.drugID = drugID;
		this.clientID = clientID;
		this.time = time;
		this.drugQuantity = drugQuantity;
}

public String getOrderID() {
	return orderID;
}
public String getDrugID() {
	return drugID;
}
public String getClientID() {
	return clientID;
}
public Date getTime() {
	return time;
}
int getDrugQuantity() {
	return drugQuantity;
}
}
