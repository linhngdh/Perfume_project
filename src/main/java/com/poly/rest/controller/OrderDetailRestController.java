package com.poly.rest.controller;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.poly.dao.OrderDetailDAO;
import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.entity.Product;
import com.poly.service.OrderDetailService;
import com.poly.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/order-details")
public class OrderDetailRestController {
	@Autowired
    OrderDetailService orderDetailService;
	
	@Autowired
	ProductService productService;

	@GetMapping("/{orderId}")
    public ResponseEntity<Map<String, Object>> getOrderDetails(@PathVariable Long orderId) {
		Order order = new Order();
		order.setId(orderId);
        // Lấy thông tin chi tiết hóa đơn
        List<OrderDetail> orderDetails = orderDetailService.getOrderDetails(order);

        // Tạo đối tượng Map chứa cả hai loại thông tin
        Map<String, Object> response = new HashMap<>();
        response.put("orderDetails", orderDetails);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
