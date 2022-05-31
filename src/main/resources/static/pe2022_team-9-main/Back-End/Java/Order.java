package PMS;

import java.util.*;

public class Order {
	String orderID;
	String drugID;
	String clientID;
	Date time;
	int drugQuantity;

String getOrderID() {
	return orderID;
}
String getDrugID() {
	return drugID;
}
String getClientID() {
	return clientID;
}
Date getTime() {
	return time;
}
int getDrugQuantity() {
	return drugQuantity;
}
}
