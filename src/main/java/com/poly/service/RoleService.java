package com.poly.service;

import java.util.List;
import java.util.Optional;

import com.poly.entity.Role;



public interface RoleService {
	public List<Role> findAll();
	Role findByName(String name);
	
	Optional<Role> findById(String id);

}
