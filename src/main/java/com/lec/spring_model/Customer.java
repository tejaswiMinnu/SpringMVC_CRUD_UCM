package com.lec.spring_model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private int cId;

	private String cName;

	private String cPassword;

	private List<Order> orders = new ArrayList<Order>();

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public String getcPassword() {
		return cPassword;
	}

	public void setcPassword(String cPassword) {
		this.cPassword = cPassword;
	}
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}	
}