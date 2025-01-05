package com.poly.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poly.dao.OrderDAO;
import com.poly.dao.OrderDetailDAO;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderDetailDAO ddao;
	
	@Override
    public List<Order> getAllOrders() {
        return dao.findAll();
    }
	
	@Override
    public void updateOrderStatus(Long id, String status) {
        Order order = dao.findById(id).orElse(null);
        if (order != null) {
            order.setStatus(status);
            dao.save(order);
        } else {
            // Xử lý trường hợp không tìm thấy đơn hàng
            // Điều này có thể bao gồm việc log thông báo hoặc ném một ngoại lệ
        }
    }

	@Override
	public Order create(JsonNode orderData) {
		 ObjectMapper mapper = new ObjectMapper();

	        // Convert orderData to Order object
	        Order order = mapper.convertValue(orderData, Order.class);

	        // Set the status explicitly
	        order.setStatus("Chờ xác nhận");

	        // Save the order to the database
	        dao.save(order);

	        // Convert orderDetails in orderData to List<OrderDetail>
	        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
	        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type)
	                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
	        
	        // Save all orderDetails to the database
	        ddao.saveAll(details);
	        
	        return order;
	}

	@Override
	public Order findById(Long id) {
		return dao.findById(id).get();
	}

	@Override
	public List<Order> findByUsername(String username) {
		
		return dao.findByUsername(username);
	}

	@Override
	public List<Order> findAll() {
		return dao.findAll();
	}

	@Override
	public Order update(Order order) {
		return dao.save(order);
	}

	public List<Order> getOrdersByMonth(int month) {
        return dao.findOrdersByMonth(month);
    }
	
}
