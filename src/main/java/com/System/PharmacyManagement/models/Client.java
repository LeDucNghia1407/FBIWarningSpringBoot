package com.System.PharmacyManagement.models;

import javax.persistence.*;
//Plain Object Java Object = POJO
@Entity //This is a table in Database
@Table(name="Client")  // Create a Table name Client

public class Client {


	//This is "primary key"
	@Id
	//Generate a table name <<Entity name>> sequence
	@SequenceGenerator(
			name = "client_sequence",
			sequenceName = "client_sequence",
			allocationSize = 1 //increment by 1
	)

	//Increase the valye in <<Entity name>> sequence table
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator =  "client_sequence"
	)
	@Column(name = "id", nullable = false)
	private Long id;
	//validate = constraint


	private String clientID;
	private String employeeID;

	public Client() {
	}

	//Calculated field = transient

	//Create Client constructor

	public Client(String clientID, String employeeID) {
		this.id = id;
		this.clientID = clientID;
		this.employeeID = employeeID;
	}


	//Set and get Operation


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


	//Return info to string method


	@Override
	public String toString(){
		return "Client{" + "Id: "+ id + ", Client Name: " +clientID +", EmployeeId: "+ employeeID+"}";
	}
}