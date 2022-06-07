package com.System.PharmacyManagement.models;



import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "Orders")
public class Orders {


	@Id
	private String orderID;
	@Column(name = "clientID", nullable = false)
	private String clientID;
	@Column(name = "drugID", nullable = false)
	private String drugID;
	@Column(name = "time", nullable = false)
	private Date time;
	@Column(name = "drugQuantity", nullable = false)
	private int drugQuantity;

	public Orders() {
	}



	public Orders(String orderID, String clientID, String drugID, Date time, int drugQuantity) {
		this.orderID = orderID;
		this.clientID = clientID;
		this.drugID = drugID;
		this.time = time;
		this.drugQuantity = drugQuantity;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public void setDrugID(String drugID) {
		this.drugID = drugID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setDrugQuantity(int drugQuantity) {
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
public int getDrugQuantity() {
	return drugQuantity;
}
	@Override
	public String toString(){
		return "Order {"  + ", Order ID: " + orderID +", Drug ID: "+ drugID+", Client ID: "+ clientID+", Time: "+ time+", Drug Quantity: "+ drugQuantity+"}";
	}

}
