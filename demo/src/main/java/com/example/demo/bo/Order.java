package com.example.demo.bo;

import java.util.List;

public class Order {

	private long orderNumber;
	
	private long userId;
	
	private List<Product> products;

	public long getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(long orderNumber) {
		this.orderNumber = orderNumber;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Order [orderNumber=" + orderNumber + ", userId=" + userId + ", products=" + products + "]";
	}
	
}
