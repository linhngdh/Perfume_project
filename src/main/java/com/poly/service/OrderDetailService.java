package com.poly.service;

import java.util.List;

import com.poly.entity.Order;
import com.poly.entity.OrderDetail;

public interface OrderDetailService {
	List<OrderDetail> getOrderDetails(Order order);
	
	List<Object[]> getTopSoldProducts();
	
}
