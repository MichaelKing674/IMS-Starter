package com.qa.ims.persistence.domain;

public class Order {
	
	private int id;
	private int customerId;

	public Order(int customerId) {
		this.setCustomerId(customerId);
	}

	public Order(int id, int customerId) {
		this.setId(id);
		this.setCustomerId(customerId);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Order ID:" + id + " Customer ID:" + customerId;
	}

//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((customerId == null) ? 0 : customerId.hashCode());
//		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
//		return result;
//	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (!(getCustomerId() == (other.getCustomerId())))
			return false;
		if (id == 0) {
			if (other.id != 0)
				return false;
		} else if (id != (other.id)) {
			return false;
		}
		return true;
	}
}
