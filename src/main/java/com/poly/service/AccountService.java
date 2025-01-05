package com.poly.service;

import java.util.List;

import com.poly.entity.Account;



public interface AccountService {
	public List<Account> findAll();

	public Account findByUsername(String username);

	public List<Account> getAdministrators();

	public Account update(Account account);

	public void deleteById(String username);

	public Account create(Account account);

	public List<Account> findRequest(String string);

}
