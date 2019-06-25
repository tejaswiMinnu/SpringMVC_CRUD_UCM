package com.lec.spring_model;

import java.util.ArrayList;
import java.util.List; 

public class Product {

	private int pId;

	private String pDesc;

	private int qtyInStock; 

	private List<Order> ordersForProduct = new ArrayList<Order>();

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpDesc() {
		return pDesc;
	}

	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}

	public int getQtyInStock() {
		return qtyInStock;
	}

	public void setQtyInStock(int qtyInStock) {
		this.qtyInStock = qtyInStock;
	}

	public List<Order> getOrdersForProduct() {
		return ordersForProduct;
	}

	public void setOrdersForProduct(List<Order> ordersForProduct) {
		this.ordersForProduct = ordersForProduct;
	}

}
