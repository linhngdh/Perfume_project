package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Brand;
import com.poly.service.BrandService;

@Controller
public class BrandController {
	@Autowired
	BrandService  brandservice;
	@RequestMapping("/thuongHieu")
	public String brand(Model model) {
		
			 //list = BrandService.findAll();
			 List<Brand> list = brandservice.findAll();
	
		model.addAttribute("brand_items", list);
		return "thuongHieu";
	}
}
