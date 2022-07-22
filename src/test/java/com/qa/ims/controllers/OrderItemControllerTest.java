package com.qa.ims.controllers;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.qa.ims.controller.OrderItemController;
import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

@RunWith(MockitoJUnitRunner.class)
public class OrderItemControllerTest {
	
	@Mock
	private Utils utils;

	@Mock
	private OrderItemDAO dao;

	@InjectMocks
	private OrderItemController controller;

	@Test
	public void testCreate() {
		final int orderitem_id = 1;
		final int order_id = 3;
		final int item_id = 5;
		final int quantity = 7;
		final OrderItem created = new OrderItem(orderitem_id,order_id,item_id,quantity);

		Mockito.when(utils.getInt()).thenReturn(orderitem_id,order_id,item_id,quantity );
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(4)).getInt();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() { 
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1, 2, 3, 4));

		Mockito.when(dao.readAll()).thenReturn(items);

		assertEquals(items, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

	@Test
	public void testUpdate() {
		OrderItem updated = new OrderItem(1, 2, 3, 4);

		Mockito.when(this.utils.getInt()).thenReturn(updated.getOrderitem_id());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getOrder_id());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getItem_id());
		Mockito.when(this.utils.getInt()).thenReturn(updated.getQuantity());
		Mockito.when(this.dao.update(updated)).thenReturn(updated);

		assertEquals(updated, this.controller.update());

		Mockito.verify(this.utils, Mockito.times(4)).getInt();
		Mockito.verify(this.dao, Mockito.times(1)).update(updated);
	}

	@Test
	public void testDelete() {
		final int ID = 1;

		Mockito.when(utils.getInt()).thenReturn(ID);
		Mockito.when(dao.delete(ID)).thenReturn(1);

		assertEquals(1, this.controller.delete());

		Mockito.verify(utils, Mockito.times(1)).getInt();
		Mockito.verify(dao, Mockito.times(1)).delete(ID);
	}
		
}
