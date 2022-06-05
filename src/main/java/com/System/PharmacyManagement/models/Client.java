package com.System.PharmacyManagement.models;

import javax.persistence.*;
//Plain Object Java Object = POJO
@Entity
@Table(name="Client")
public class Client {

	@Id
	//This is "primary key"
	@SequenceGenerator(
			name = "client_sequence",
			sequenceName = "client_sequence",
			allocationSize = 1 //increment by 1
	)
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
	public Client(String clientID, String employeeID) {
		this.id = id;
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
		return "Client{" + "Id: "+ id + ", Client Name: " +clientID +", EmployeeId: "+ employeeID+"}";
	}
}