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
import org.springframework.web.bind.annotation.RestController;

import com.poly.entity.Account;
import com.poly.entity.Brand;
import com.poly.service.BrandService;


@CrossOrigin("*")
@RestController
@RequestMapping("/rest/brands")
public class BrandRestController {
	@Autowired
	BrandService brandService;

	@GetMapping()
	public List<Brand> getAll() {
		return brandService.findAll();
	}

	@GetMapping("{id}")
	public Brand getOne(@PathVariable("id") String id) {
		return brandService.findById(id);
	}

	@PostMapping()
	public Brand create(@RequestBody Brand Brand) {
		return brandService.create(Brand);
	}

	@PutMapping("{id}")
	public Brand update(@PathVariable("id") Integer id, @RequestBody Brand Brand) {
		return brandService.update(Brand);
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") String id) {
		brandService.delete(id);
	}

	@GetMapping("search/{info}")
	public List<Brand> getRequest(@PathVariable("info")Optional<String> request) {
		String kwords = request.orElse("");
		return brandService.findRequest("%"+kwords+"%");
	}
}
