package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;
import com.poly.entity.Brand;


public interface BrandDAO extends JpaRepository<Brand, String>{
	@Query("SELECT a FROM Brand a WHERE a.Trademark LIKE %?1%")
	List<Brand> findRequest(String string); 
	
//	@Query("SELECT a FROM Brand a WHERE a.trademark LIKE %?1%")
//	List<Brand> findByKeyword(String key);

}
