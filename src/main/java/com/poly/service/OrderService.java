package com.poly.service;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.entity.Order;
import com.poly.entity.Product;

public interface OrderService {
	List<Order> findAll();
	
	Order create(JsonNode orderData);

	Order findById(Long id);

	List<Order> findByUsername(String username);
	
	List<Order> getAllOrders();
    
	Order update(Order order);
	
	List<Order> getOrdersByMonth(int month);

	void updateOrderStatus(Long id, String status);
}
