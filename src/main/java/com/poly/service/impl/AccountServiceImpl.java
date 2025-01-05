package com.poly.service.impl;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.entity.Authority;
import com.poly.entity.Role;
import com.poly.service.AccountService;
import com.poly.service.AuthorityService;
import com.poly.service.RoleService;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountDAO adao;
	@Autowired
	RoleService roleService;
	@Autowired
	AuthorityService authService;
	
	
	@Override
	public Account findByUsername(String username) {
		return adao.findByUsername(username);
	}

	
	@Override
	public List<Account> findAll() {
		return adao.findAll();
	}

	@Override
	public List<Account> getAdministrators() {
		return adao.getAdministrators();
	}

	@Override
	public Account update(Account account) {
		return adao.save(account); 
	}

	/*
	 * @Override public void deleteById(String username) {
	 * adao.deleteById(username); }
	 */
	@Override
	 public void deleteById(String username) {
	        // Kiểm tra nếu tài khoản có Role ID là "DIRE", ném ngoại lệ
	        Account account = adao.findById(username).orElse(null);
	        if (isAdminAccount(account)) {
	            throw new IllegalArgumentException("Cannot delete account with Role ID 'DIRE'");
	        }

	        // Nếu không phải là tài khoản có Role ID là "DIRE", thực hiện xóa
	        adao.deleteById(username);
	    }

	    private boolean isAdminAccount(Account account) {
	        // Kiểm tra nếu Role ID là "DIRE"
	        return account != null && account.getAuthorities().stream()
	                .anyMatch(authority -> authority.getRole().getId().equals("DIRE"));
	    }
	
	/*
	 * public Account create(Account account) {
	 * 
	 * return adao.save(account); }
	 */
	 

	@Override
	public List<Account> findRequest(String string) {
		return adao.findRequest(string); 
	}


	 @Transactional
	    public Account create(Account account) {
	        // Tạo tài khoản
	        Account createdAccount = adao.save(account);

	        // Tìm quyền có ID là "CUST"
	        Role customerRole = roleService.findById("CUST").orElse(null);

	        // Kiểm tra nếu quyền "CUST" không tồn tại thì bạn có thể xử lý tùy ý, ví dụ: ném một ngoại lệ.

	        // Tạo quyền với quyền "CUST"
	        Authority authority = new Authority();
	        authority.setRole(customerRole);
	        authority.setAccount(createdAccount);
	        authService.create(authority);

	        // Cập nhật tài khoản với quyền mới
	        createdAccount.setAuthorities(Collections.singletonList(authority));

	        return createdAccount;
	    }


}
