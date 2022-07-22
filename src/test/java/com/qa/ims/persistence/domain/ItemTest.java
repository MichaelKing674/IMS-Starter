package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ItemTest {
	
	@Test
	public void testGetItemId() {
		Item item = new Item(1,"Computer",299.99);
		assertEquals(1,item.getItemId());
	}
	
	@Test
	public void testSetItemId() {
		Item item = new Item(1,"Computer", 299.99);
		item.setId(2);
		assertEquals(2,item.getItemId());
	}
	
	@Test
	public void testGetPrice() {
		Item item = new Item(1,"Computer",299.99);
		assertEquals(299.99,item.getPrice(),0);
	}
	
	@Test
	public void testSetPrice() {
		Item item = new Item(1,"Computer", 299.99);
		item.setPrice(249.99);
		assertEquals(249.99,item.getPrice(),0);
	}
	
	@Test
	public void testGetName() {
		Item item = new Item(1,"Computer",299.99);
		assertEquals("Computer",item.getName());
	}
	
	@Test
	public void testSetName() {
		Item item = new Item(1,"Computer", 299.99);
		item.setName("PC");
		assertEquals("PC",item.getName());
	}
	
}
