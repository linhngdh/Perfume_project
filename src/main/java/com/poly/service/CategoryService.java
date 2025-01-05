package com.poly.service;

import java.util.List;

import com.poly.entity.Category;



public interface CategoryService {
	List<Category> findAll();
	
	Category create(Category Category);

	Category update(Category Category);

	Category findById(String id);
	
	void delete(Integer id);
}
