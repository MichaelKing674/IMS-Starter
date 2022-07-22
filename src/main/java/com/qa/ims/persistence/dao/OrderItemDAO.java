package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.persistence.domain.OrderItem;
import com.qa.ims.utils.DBUtils;

public class OrderItemDAO implements Dao<OrderItem> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	@Override
	public OrderItem modelFromResultSet(ResultSet resultSet) throws SQLException {
		int id = resultSet.getInt("orderitem_id");
		int order = resultSet.getInt("order_id");
		int item = resultSet.getInt("item_id");
		int quantity = resultSet.getInt("quantity");
		double cost = resultSet.getDouble("s");
		return new OrderItem(id, order, item, quantity, cost);
	}  

	/**
	 * Reads all orderItems from the database
	 * 
	 * @return A list of orderItems
	 */
	@Override
	public List<OrderItem> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems ORDER BY order_id DESC LIMIT 1");) {
			List<OrderItem> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems; 
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	

	public OrderItem readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM orderitems ORDER BY orderitem_id DESC LIMIT 1");) {
			resultSet.next();
			return modelFromResultSet(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an orderItem in the database
	 * 
	 * @param orderItem - takes in an orderItem object. id will be ignored
	 */
	@Override
	public OrderItem create(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO orderItems(orderitem_id,order_id, item_id, quantity) VALUES (?, ?, ?, ?)");) {
			statement.setInt(1, orderItem.getOrderitem_id());
			statement.setInt(2, orderItem.getOrder_id());
			statement.setInt(3, orderItem.getItem_id());
			statement.setInt(4, orderItem.getQuantity());
			statement.executeUpdate();
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	@Override
	public OrderItem read(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT * FROM orderitems WHERE orderitem_id = ?");) {
			statement.setInt(1, id);
			try (ResultSet resultSet = statement.executeQuery();) {
				resultSet.next();
				return modelFromResultSet(resultSet);
			}
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Updates an orderItem in the database
	 * 
	 * @param orderItem - takes in an orderItem object, the id field will be used to
	 *                 update that orderItem in the database
	 * @return
	 */
	@Override
	public OrderItem update(OrderItem orderItem) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection
						.prepareStatement("UPDATE orderitems SET quantity = ? WHERE orderitem_id = ?");) {
			statement.setInt(1, orderItem.getQuantity());
			statement.setInt(2, orderItem.getOrderitem_id());
			statement.executeUpdate();
			return read(orderItem.getOrderitem_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Deletes an orderItem in the database
	 * 
	 * @param id - id of the orderItem
	 */
	@Override
	public int delete(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("DELETE FROM orderitems WHERE orderitem_id = ?");) {
			statement.setInt(1, id);
			return statement.executeUpdate();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}

	public List<OrderItem> readAll(int id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				PreparedStatement statement = connection.prepareStatement("SELECT orderitem_id, i.item_id, order_id, quantity, SUM(price * quantity) AS s FROM orderitems oi JOIN items i ON i.item_id = oi.item_id WHERE order_id = ?");) {
				statement.setInt(1, id);
				ResultSet resultSet = statement.executeQuery();
			List<OrderItem> orderItems = new ArrayList<>();
			while (resultSet.next()) {
				orderItems.add(modelFromResultSet(resultSet));
			}
			return orderItems; 
		} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}
	

}
