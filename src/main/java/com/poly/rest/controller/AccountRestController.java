package com.poly.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.poly.dao.AccountDAO;
import com.poly.entity.Account;
import com.poly.service.AccountService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountDAO accountService;
	@Autowired
	AccountService accService;
	@GetMapping
	public List<Account>getAccounts(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return accountService.getAdministrators();
		}
		return accountService.findAll();
	}
	
	@GetMapping("create")
	public List<Account>getAll(){
		return accountService.findAll();
	}
	
	@PutMapping("{username}")
	public Account updateAcount(@RequestBody Account account) {
		return accService.update(account); 
	}
	
	@DeleteMapping("{username}")
	public void deleteAccount(@PathVariable("username")String username) {
		accService.deleteById(username);
	}
	
	@PostMapping()
	public Account createAccount(@RequestBody Account account) {
		return accService.create(account);
	}
//	//Tìm account
	@GetMapping("search/{info}")
	public List<Account> getRequest(@PathVariable("info")Optional<String> request) {
		String kwords = request.orElse("");
		return accService.findRequest("%"+kwords+"%");
	}
	
}
