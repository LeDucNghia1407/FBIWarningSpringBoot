package com.System.PharmacyManagement.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "Order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Long id;

	private String orderID;
	private String drugID;
	private String clientID;
	private Date time;
	private int drugQuantity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	@Override
	public String toString(){
		return "Manager{" + "Id: "+ id + ", Order ID: " + orderID +", Drug ID: "+ drugID+", Client ID: "+ clientID+", Time: "+ time+", Drug Quantity: "+ drugQuantity+"}";
	}

}
