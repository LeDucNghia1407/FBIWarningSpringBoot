package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {
	@Id
	@SequenceGenerator(
			name = "order_sequence",
			sequenceName = "order_sequence",
			allocationSize = 1 //increment by 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "order_sequence"
	)
	@Column(name = "id", nullable = false)
	private Long id;

	private String orderID;
	private String clientID;
	private String drugID;

	private String time;
	private int drugQuantity;

	public Orders() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Orders(String orderID, String clientID, String drugID, String time, int drugQuantity) {
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

	public void setTime(String time) {
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
public String getTime() {
	return time;
}
public int getDrugQuantity() {
	return drugQuantity;
}
	@Override
	public String toString(){
		return "Manager{" + "Id: "+ id + ", Order ID: " + orderID +", Drug ID: "+ drugID+", Client ID: "+ clientID+", Time: "+ time+", Drug Quantity: "+ drugQuantity+"}";
	}

}
