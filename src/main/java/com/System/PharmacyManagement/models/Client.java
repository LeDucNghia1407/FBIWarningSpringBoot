package com.System.PharmacyManagement.models;

import javax.persistence.*;

@Entity
public class Client {
	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String clientID;
	private String employeeID;

	public Client() {
	}

	public Client(String clientID, String employeeID) {
		this.clientID = clientID;
		this.employeeID = employeeID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	@Override
	public String toString(){
		return "Client{" + "Id: "+ id + ", Client Name: " +clientID +", EmployeeId"+ employeeID+"}";
	}
}