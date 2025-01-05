package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.CategoryDAO;
import com.poly.entity.Brand;
import com.poly.entity.Category;
import com.poly.service.CategoryService;


@Service
public class CategoryServicelmpl implements CategoryService {
	@Autowired
	CategoryDAO cdao;

	@Override
	public List<Category> findAll() {
		return cdao.findAll();
	}

	@Override
	public Category create(Category categories) {
		// TODO Auto-generated method stub
		return cdao.save(categories);
	}

	@Override
	public Category update(Category categories) {
		// TODO Auto-generated method stub
		return cdao.save(categories);
	}

	@Override
	public Category findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		cdao.deleteById(id);
	}
}
