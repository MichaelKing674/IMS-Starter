package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class CustomerTest {

//	@Test
//	public void testEquals() {
//		EqualsVerifier.simple().forClass(Customer.class).verify();
//	}
	
	@Test
	public void testGetId() {
		Customer customer = new Customer(1,"Michael","King");
		assertEquals(1,customer.getId());
	}
	
	@Test
	public void testSetId() {
		Customer customer = new Customer(1,"Michael","King");
		customer.setId(2);
		assertEquals(2,customer.getId());
	}
	
	@Test
	public void testGetFirstName() {
		Customer customer = new Customer(1,"Michael","King");
		assertEquals("Michael",customer.getFirstName());
	}
	
	@Test
	public void testSetFirstName() {
		Customer customer = new Customer(1,"Michael","King");
		customer.setFirstName("Daniel");
		assertEquals("Daniel",customer.getFirstName());
	}
	
	@Test
	public void testGetSurname() {
		Customer customer = new Customer(1,"Michael","King");
		assertEquals("King",customer.getSurname());
	}
	
	@Test
	public void testSetSurname() {
		Customer customer = new Customer(1,"Michael","King");
		customer.setSurname("Queen");
		assertEquals("Queen",customer.getSurname());
	}

}
