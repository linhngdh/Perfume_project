package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;
import com.poly.entity.OrderDetail;


public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	List<OrderDetail> findAllByOrder(Order order);

	@Query("SELECT od.product.product_id, od.product.product_name, SUM(od.quantity) FROM OrderDetail od GROUP BY od.product.product_id, od.product.product_name ORDER BY SUM(od.quantity) DESC")
    List<Object[]> findTopSoldProducts();
}
