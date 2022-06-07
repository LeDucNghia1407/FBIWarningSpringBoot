package com.System.PharmacyManagement.models;

import javax.persistence.*;
//Plain Object Java Object = POJO
@Entity //This is a table in Database
@Table(name="Client")  // Create a Table name Client
public class Client {


	//This is "primary key"

	//Generate a table name <<Entity name>> sequence




	//validate = constraint




	@Id
	private String clientID;
	@Column(name = "employeeID",nullable = false)
	private String employeeID;

	public Client() {
	}

	//Calculated field = transient

	//Create Client constructor

	public Client(String clientID, String employeeID) {
		this.clientID = clientID;
		this.employeeID = employeeID;
	}


	//Set and get Operation




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


	//Return info to string method


	@Override
	public String toString(){
		return "Client{ " +  ": Client ID: " +clientID + "  EmployeeId: "+ employeeID+"}";
	}
}