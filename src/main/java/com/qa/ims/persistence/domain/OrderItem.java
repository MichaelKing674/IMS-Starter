package com.qa.ims.persistence.domain;

import java.util.Objects;

public class OrderItem {
	
	private int orderitem_id;
	private int order_id;
	private int item_id;
	private int quantity;
	private double cost;
	
	public OrderItem(int orderitem_id, int order_id, int item_id, int quantity, double cost) {
		this.orderitem_id = orderitem_id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
		this.cost = cost;
	}
	
	
	public OrderItem(int orderitem_id, int order_id, int item_id, int quantity) {
		this.orderitem_id = orderitem_id;
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public OrderItem(int order_id, int item_id, int quantity) {
		this.order_id = order_id;
		this.item_id = item_id;
		this.quantity = quantity;
	}

	public OrderItem(int orderitem_id, int quantity) {
		super();
		this.orderitem_id = orderitem_id;
		this.quantity = quantity;
	}

	public int getOrderitem_id() {
		return orderitem_id;
	}

	public void setOrderitem_id(int orderitem_id) {
		this.orderitem_id = orderitem_id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getItem_id() {
		return item_id;
	}

	public void setItem_id(int item_id) {
		this.item_id = item_id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}


	@Override
	public String toString() {
		return "OrderItem [orderitem_id=" + orderitem_id + ", order_id=" + order_id + ", item_id=" + item_id
				+ ", quantity=" + quantity + " , cost=" + cost + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, order_id, orderitem_id, quantity);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return item_id == other.item_id && order_id == other.order_id && orderitem_id == other.orderitem_id
				&& quantity == other.quantity;
	}
	
	
	
	
	
	
}
