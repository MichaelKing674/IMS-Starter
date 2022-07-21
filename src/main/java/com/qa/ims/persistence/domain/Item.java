package com.qa.ims.persistence.domain;

import java.util.Objects;

public class Item {
	private int item_id;
	private String item_name;
	private double price;
	
	public Item(String item_name) {
		this.setName(item_name);
	}

	public Item(int item_id, String item_name) {
		this.setId(item_id);
		this.setName(item_name);
	}
	
	public Item(String item_name, double price) {
		this.setName(item_name);
		this.setPrice(price);
	}
	
	public Item(int item_id, String item_name, double price) {
		this.setId(item_id);
		this.setName(item_name);
		this.setPrice(price);
	}

	public int getItemId() {
		return item_id;
	}

	public void setId(int item_id) {
		this.item_id = item_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return item_name;
	}

	public void setName(String name) {
		this.item_name = name;
	}

	@Override
	public String toString() {
		return "Item ID:" + item_id + " Item Name:" + item_name + " Item Price: " + price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(item_id, item_name, price);
	} 

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		return item_id == other.item_id && Objects.equals(item_name, other.item_name)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price);
	}

	
}
