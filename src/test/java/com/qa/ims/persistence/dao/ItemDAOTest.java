package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.DBUtils;

public class ItemDAOTest {
	
	private final ItemDAO DAO = new ItemDAO();

	@Before
	public void setupItem() {
		DBUtils.connect();
		DBUtils.getInstance().init("src/test/resources/sql-schema.sql", "src/test/resources/sql-data.sql");
	}

	@Test
	public void testCreateItem() {
		final Item created = new Item(1,"Computer", 300);
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAllItem() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1,"Computer", 300));
		assertEquals(expected, DAO.readAll());
	}

	@Test
	public void testReadLatestItem() {
		assertEquals(new Item(1,"Computer", 300), DAO.readLatest());
	}

	@Test
	public void testReadItem() {
		final int ID = 1;
		assertEquals(new Item(ID,"Computer", 300), DAO.read(ID));
	}

	@Test
	public void testUpdateItem() {
		final Item updated = new Item(1,"Computer", 300);
		assertEquals(updated, DAO.update(updated));

	}

	@Test
	public void testDeleteItem() {
		assertEquals(1, DAO.delete(1));
	}
}
