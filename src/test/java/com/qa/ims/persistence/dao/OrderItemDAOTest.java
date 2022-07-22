package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAOTest {
	
	private final OrderItemDAO DAO = new OrderItemDAO();

	@Before
	public void setupItem() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}
	
	@After
	public void clear() {
		DAO.delete(1);
		DAO.delete(2);
		DAO.delete(3);
		DAO.delete(4);
		DAO.delete(5);
	}

	@Test
	public void testCreateOrderItem() {
		final OrderItem created = new OrderItem(1, 2, 3, 4);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAllOrderItem() {
		List<OrderItem> expected = new ArrayList<>();
		expected.add(new OrderItem(1, 2, 3, 4));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatestOrderItem() {
		assertEquals(new OrderItem(1, 2, 3, 4), DAO.readLatest());
	}

	@Test
	public void testReadItem() {
		final int ID = 1;
		assertEquals(new OrderItem(ID, 2, 3, 4), DAO.read(ID));
	}

	@Test
	public void testUpdateItem() {
		final OrderItem updated = new OrderItem(1, 2, 3, 4);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.delete(1));
	}
}
