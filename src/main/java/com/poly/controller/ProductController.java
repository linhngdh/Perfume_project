package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Product;
import com.poly.service.ProductService;

@Controller

public class ProductController {
	@Autowired
	ProductService productService;

	@RequestMapping("/product")
	public String index(Model model, @RequestParam(name = "keyword", required = false) Optional<String> keyword,
			@RequestParam(name = "cid", required = false) Optional<Integer> cid,
			@RequestParam(name = "priceRange", required = false) Optional<String> priceRange,
	        @RequestParam(name = "searchByCapacity", required = false, defaultValue = "false") boolean searchByCapacity,
	        @RequestParam(name = "capacity", required = false) Optional<Double> capacity){

		List<Product> list;
		if (searchByCapacity) {
            // Tìm sản phẩm có dung tích bằng với giá trị capacity
            if (capacity.isPresent()) {
                list = productService.findByCapacity(capacity.get());
            } else {
                // Nếu ô kiểm tìm kiếm theo dung tích được chọn nhưng không có giá trị capacity, xử lý theo ý của bạn
                list = productService.findAll(); // Hoặc bạn có thể xử lý theo cách khác tùy thuộc vào yêu cầu
              }
            
          }else if (priceRange.isPresent()) {
            // Tách giá trị min và max từ priceRange
            String[] priceValues = priceRange.get().split("-");
            double minPrice = Double.parseDouble(priceValues[0]);
            double maxPrice = Double.parseDouble(priceValues[1]);

            // Tìm sản phẩm trong khoảng giá từ minPrice đến maxPrice
            list = productService.findByPriceBetween(minPrice, maxPrice);
        }
		else if (keyword.isPresent()) {
			String keywordValue = keyword.get();
			if (isNumeric(keywordValue)) {
				list = productService.findByBrand(keywordValue);
			} else {
				list = productService.findByKeyword(keywordValue);
			}
		} else if (cid.isPresent()) {
			list = productService.findByCategoryId(cid.get());
		}
		//findbypricebetween
		
		//
		else {
			list = productService.findAll();
		}
		model.addAttribute("items", list);
		return "product";
	}


	// Hàm kiểm tra xem một chuỗi có phải là số hay không
	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@RequestMapping("/product/chitietSP/{product_id}")
	public String detail(Model model, @PathVariable("product_id") int product_id) {
		Product item = productService.findById(product_id);
		model.addAttribute("item", item);
		return "product/chitietSP";
	}

}
