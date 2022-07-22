package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {
	
	@Test
	public void testGetId() {
		Order order = new Order(1,3);
		assertEquals(1,order.getId());
	}
	
	@Test
	public void testSetId() {
		Order order = new Order(1,3);
		order.setId(2);
		assertEquals(2,order.getId());
	}
	
	@Test
	public void testGetCustomerId() {
		Order order = new Order(1,3);
		assertEquals(3,order.getCustomerId());
	}
	
	@Test
	public void testSetCustomerId() {
		Order order = new Order(1,3);
		order.setCustomerId(4);
		assertEquals(4,order.getCustomerId());
	}
}
