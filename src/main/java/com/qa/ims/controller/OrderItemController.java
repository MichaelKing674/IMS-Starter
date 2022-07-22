package com.qa.ims.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderItemDAO;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.Utils;

public class OrderItemController implements CrudController<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderItemDAO orderItemDAO;
	private Utils utils;

	public OrderItemController(OrderItemDAO orderItemDAO, Utils utils) {
		super();
		this.orderItemDAO = orderItemDAO;
		this.utils = utils;
	}

	/**
	 * Reads all customers to the logger
	 */
	@Override
	public List<OrderItem> readAll() {
		LOGGER.info("Would you like the cost of an order");
		String answer1 = utils.getString();
		if (answer1.equals("yes")) {
			LOGGER.info("What is the order id you'd like the cost for");
			int answer2 = utils.getInt();
			List<OrderItem> orderItems = orderItemDAO.readAll(answer2);
			for (OrderItem orderItem : orderItems) {
				LOGGER.info(orderItem);
			}
			return orderItems;
		} else {
		List<OrderItem> orderItems = orderItemDAO.readAll();
		for (OrderItem orderItem : orderItems) {
			LOGGER.info(orderItem);
		}
		return orderItems;
		}
	}

	/**
	 * Creates a customer by taking in user input
	 */
	@Override
	public OrderItem create() {
		LOGGER.info("Please enter an orderItem ID");
		int id = utils.getInt();
		LOGGER.info("Please enter an order ID");
		int orderID = utils.getInt();
		LOGGER.info("Please enter an item ID");
		int itemID = utils.getInt();
		LOGGER.info("Please enter a quantity");
		int quantity = utils.getInt();
		OrderItem orderItem = orderItemDAO.create(new OrderItem(id,orderID,itemID,quantity));
		LOGGER.info("OrderItem created");
		return orderItem;
	}

	/**
	 * Updates an existing customer by taking in user input
	 */
	@Override
	public OrderItem update() {
		LOGGER.info("Please enter the id of the OrderItem you would like to update");
		int id = utils.getInt();
		LOGGER.info("Please enter a new Quantity");
		int quantity = utils.getInt();
		OrderItem orderItem = orderItemDAO.update(new OrderItem(id, quantity));
		LOGGER.info("OrderItem Updated");
		return orderItem;
	}

	/**
	 * Deletes an existing customer by the id of the customer
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the Order Item you would like to delete");
		int id = utils.getInt();
		LOGGER.info("OrderItem Deleted");
		return orderItemDAO.delete(id);
	}
	
}
