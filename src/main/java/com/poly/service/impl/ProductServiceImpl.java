package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.ProductDAO;
import com.poly.entity.Product;
import com.poly.service.ProductService;




@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}

	@Override
	public Product findById(int product_id) {
		return pdao.findById(product_id).get();
	}
	
	@Override
	public List<Product> findByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return this.pdao.findByKeyword(keyword);
	}


	@Override
	public List<Product> findByBrand(String keyword) {
		// TODO Auto-generated method stub
		return this.pdao.findByBrand(keyword);
	}

	@Override
	public Product create(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

	@Override
	public Product update(Product product) {
		// TODO Auto-generated method stub
		return pdao.save(product);
	}

//	@Override
//	public void delete(Integer product_id) {
//		// TODO Auto-generated method stub
//		pdao.deleteById(product_id);
//	}

	@Override
	public List<Product> findByCategoryId(Integer cid) {
		// TODO Auto-generated method stub
		return this.pdao.findByCategoryId(cid);
	}

	@Override
	public void delete(Integer product_id) {
		// TODO Auto-generated method stub
		pdao.deleteById(product_id);
	}

	@Override
	public List<Product> getProductsByOrderId(Long orderId) {
		// Giả định rằng có một phương thức trong repository để lấy sản phẩm dựa trên orderId
        return this.pdao.findByOrderId(orderId);
	}

	@Override
	public List<Product> findByPriceBetween(double minPrice, double maxPrice) {
		// TODO Auto-generated method stub
		return pdao.findByPriceBetween(minPrice, maxPrice);
	}
	
	@Override
	public List<Product> findByCapacity(Double capacity) {
		// TODO Auto-generated method stub
		return pdao.findByCapacity(capacity);
	}
	
}
//	@Override
//	public List<Product> findByCategoryId(String id) {
//		return pdao.findByCategoryId(id);
//	}

//	@Override
//	public Product create(Product product) {
//		return pdao.save(product);
//	}
//
//	@Override
//	public Product update(Product product) {
//		return pdao.save(product);
//	}
//
//	@Override
//	public void delete(String id) {
//		// TODO Auto-generated method stub
//		
//	}

//	@Override
//	public void delete(String id) {
//		pdao.deleteById(id);
//	}

//	@Override
//	public List<Product> findProduct(String request) {
//		return pdao.findProduct(request); 
//	}

	

