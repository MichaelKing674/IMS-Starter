package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;


import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();

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
	public void testCreateOrder() {
		final Order created = new Order(1, 5);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAllOrder() {
		List<Order> expected = new ArrayList<>();
		expected.add(new Order(1, 5));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatestOrder() {
		assertEquals(new Order(1, 5), DAO.readLatest());
	}

	@Test
	public void testReadItem() {
		final int ID = 1;
		assertEquals(new Order(ID, 5), DAO.read(ID));
	}

	@Test
	public void testUpdateItem() {
		final Order updated = new Order(1, 5);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.delete(1));
	}
}
