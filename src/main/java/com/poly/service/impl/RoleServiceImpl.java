package com.poly.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.RoleDAO;
import com.poly.entity.Role;
import com.poly.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	RoleDAO dao;

	@Override
    public Optional<Role> findById(String id) {
        return dao.findById(id);
    }
	
	@Override
	public Role findByName(String name) {
		return dao.findByName(name);
	}
	
	public List<Role> findAll() {
		return dao.findAll();
	}
	
	
	
}
