package com.poly.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.BrandDAO;
import com.poly.entity.Account;
import com.poly.entity.Brand;
import com.poly.entity.Product;
import com.poly.service.BrandService;

@Service
public class BrandServiceImpl implements BrandService{
	@Autowired
	BrandDAO pdao;
	
	@Override
	public List<Brand> findAll() {
		return pdao.findAll();
	}

	@Override
	public Brand create(Brand brand) {
		// TODO Auto-generated method stub
		return pdao.save(brand);
	}

	@Override
	public Brand update(Brand brand) {
		// TODO Auto-generated method stub
		return pdao.save(brand);
	}

	@Override
	public Brand findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		pdao.deleteById(id);
	}

	@Override
	public List<Brand> findRequest(String string) {
		return pdao.findRequest(string); 
	}

}
