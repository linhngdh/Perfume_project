package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.OrderDetailDAO;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderDetailService;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
	@Autowired
    OrderDetailDAO orderDetaiDAO;

	@Override
	public List<OrderDetail> getOrderDetails(Order order) {
		return orderDetaiDAO.findAllByOrder(order);
	}

	@Override
	public List<Object[]> getTopSoldProducts() {
        return orderDetaiDAO.findTopSoldProducts();
    }
}
