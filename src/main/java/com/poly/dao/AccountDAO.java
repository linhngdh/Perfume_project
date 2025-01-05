package com.poly.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Account;



public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("SELECT DISTINCT ar.account FROM Authority ar WHERE ar.role.id IN('DIRE','STAF')")
	List<Account> getAdministrators();
	
	@Query("SELECT a FROM Account a WHERE a.username LIKE ?1 or a.password LIKE ?1 "
			+ "or a.fullname LIKE ?1 or a.email LIKE ?1 or a.photo LIKE ?1")
	List<Account> findRequest(String string); 

	Account findByUsername(String username);
    
}
