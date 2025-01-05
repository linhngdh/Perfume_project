package com.poly.service;

import java.util.List;

import com.poly.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(int product_id);

	List<Product> findByKeyword(String keyword);

	List<Product> findByBrand(String keyword);

	Product create(Product product);

	Product update(Product product);

	//Tìm sản phẩm của danh mục đó
	List<Product> findByCategoryId(Integer id);

	void delete(Integer product_id);
	
	List<Product> getProductsByOrderId(Long orderId);
	
	List<Product> findByCapacity(Double capacity);

	List<Product> findByPriceBetween(double minPrice, double maxPrice);
}
