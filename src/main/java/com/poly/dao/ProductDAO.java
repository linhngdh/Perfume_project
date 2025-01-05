package com.poly.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Product;



public interface ProductDAO extends JpaRepository<Product, Integer> {

	@Query("SELECT a FROM Product a WHERE a.product_name LIKE %?1% OR a.price LIKE %?1%")
	List<Product> findByKeyword(String keyword);
	
	@Query("SELECT a FROM Product a WHERE a.brand.id=?1")
	List<Product> findByBrand(String keyword);
	
	@Query("SELECT a FROM Product a WHERE a.category.id=?1")
	List<Product> findByCategoryId(Integer id);

	@Query(value = "SELECT * FROM Products p JOIN OrderDetails od ON p.product_id = od.Product_Id WHERE od.OrderId = ?1", nativeQuery = true)
	List<Product> findByOrderId(Long orderId);
	
	List<Product> findByCapacity(Double capacity);
	List<Product> findByPriceBetween(double minPrice, double maxPrice);
	
	@Query("SELECT a FROM Product a WHERE a.product_name LIKE %?1%")
	List<Product> findProduct(String request);
}
