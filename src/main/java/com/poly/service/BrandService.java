package com.poly.service;

import java.util.List;


import com.poly.entity.Brand;


public interface BrandService {
	List<Brand> findAll();
	
	Brand create(Brand brand);

	Brand update(Brand brand);

	Brand findById(String id);
	
	void delete(String id);
	
	List<Brand> findRequest(String string);
}
