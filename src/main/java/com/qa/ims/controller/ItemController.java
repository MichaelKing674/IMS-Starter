package com.qa.ims.controller;


import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import com.qa.ims.persistence.dao.ItemDAO;
import com.qa.ims.persistence.domain.Item;
import com.qa.ims.utils.Utils;

public class ItemController implements CrudController<Item> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private ItemDAO itemDAO;
	private Utils utils;

	public ItemController(ItemDAO itemDAO, Utils utils) {
		super();
		this.itemDAO = itemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<Item> readAll() {
		List<Item> items = itemDAO.readAll();
		for (Item item : items) {
			LOGGER.info(item);
		}
		return items;
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public Item create() {
		LOGGER.info("Please enter an item ID");
		int id = utils.getInt();
		LOGGER.info("Please enter an item name");
		String buffer = utils.getString();
		String name = utils.getString();
		LOGGER.info("Please enter the price of the item");
		double price = utils.getDouble();
		Item item = itemDAO.create(new Item(id, name, price));
		LOGGER.info("Item created");
		return item; 
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public Item update() {
		LOGGER.info("Please enter the id of the item you would like to update");
		int item_id = utils.getInt();
		LOGGER.info("Please enter an item name");
		String buffer = utils.getString();
		String name = utils.getString();
		LOGGER.info("Please enter the price of the item");
		int price = utils.getInt();
		Item item = itemDAO.update(new Item(item_id, name, price));
		LOGGER.info("Item Updated");
		return item;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the item you would like to delete");
		int item_id = utils.getInt();
		LOGGER.info("Item Deleted");
		return itemDAO.delete(item_id);
	}
	
}
