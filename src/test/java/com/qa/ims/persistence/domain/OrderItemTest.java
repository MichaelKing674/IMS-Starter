package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class OrderItemTest {
	
	@Test
	public void testGetId() {
		OrderItem orderItem = new OrderItem(1, 3, 5, 7);
		assertEquals(1,orderItem.getOrderitem_id());
	}
	
	@Test
	public void testSetId() {
		OrderItem orderItem = new OrderItem(1, 3, 5, 7);
		orderItem.setOrderitem_id(2);
		assertEquals(2,orderItem.getOrderitem_id());
	}
	
	@Test
	public void testGetOrderId() {
		OrderItem orderItem = new OrderItem(1, 3, 5, 7);
		assertEquals(3,orderItem.getOrder_id());
	}
	
	@Test
	public void testSetOrderId() {
		OrderItem orderItem = new OrderItem(1, 3, 5, 7);
		orderItem.setOrder_id(4);
		assertEquals(4,orderItem.getOrder_id());
	}
	
	@Test
	public void testGetItemId() {
		OrderItem orderItem = new OrderItem(1,3, 5, 7);
		assertEquals(5,orderItem.getItem_id());
	}
	
	@Test
	public void testSetItemId() {
		OrderItem orderItem = new OrderItem(1,3, 5, 7);
		orderItem.setItem_id(4);
		assertEquals(4,orderItem.getItem_id());
	}
	
	@Test
	public void testGetQuantity() {
		OrderItem orderItem = new OrderItem(1,3, 5, 7);
		assertEquals(7,orderItem.getQuantity());
	}
	
	@Test
	public void testSetQuantity() {
		OrderItem orderItem = new OrderItem(1,3, 5, 7);
		orderItem.setQuantity(4);
		assertEquals(4,orderItem.getQuantity());
	}
	
}
