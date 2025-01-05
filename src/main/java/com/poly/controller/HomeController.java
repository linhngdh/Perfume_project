package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.poly.entity.Brand;
import com.poly.entity.Category;
import com.poly.entity.Product;
import com.poly.service.BrandService;
import com.poly.service.CategoryService;
import com.poly.service.ProductService;

@Controller
@RequestMapping("/home")
public class HomeController {
	@Autowired
	ProductService productService;

	@Autowired
	CategoryService categoryService;
	
	@GetMapping("/index")
    public String homePage(Model model, @RequestParam(name = "cid", required = false) Optional<Integer> categoryId) {
        List<Product> productList;

        if (categoryId.isPresent()) {
            // Nếu có danh mục được chọn, hiển thị sản phẩm của danh mục đó
            productList = productService.findByCategoryId(categoryId.get());
        } else {
            // Ngược lại, lấy danh sách tất cả danh mục
            List<Category> categories = categoryService.findAll();

            if (!categories.isEmpty()) {
                // Nếu có ít nhất một danh mục, lấy ID của danh mục đầu tiên và hiển thị sản phẩm của nó
                Integer firstCategoryId = categories.get(0).getId();
                productList = productService.findByCategoryId(firstCategoryId);
            } else {
                // Nếu không có danh mục nào, trả về một danh sách rỗng
                productList = List.of();
            }
        }

        model.addAttribute("items", productList);
        model.addAttribute("cates", categoryService.findAll());

        return "index";
    }
	
	@GetMapping("/loadProducts")
	@ResponseBody
	public String loadProductsByCategory(Model model, @RequestParam("cid") Integer categoryId) {
	    List<Product> productList = productService.findByCategoryId(categoryId);
	    model.addAttribute("items", productList);
	    return "fragments/productNoiBat :: productContent";
	}


//	@GetMapping("/login")
//	public String login() {
//		return "security/login";
//	}
	@GetMapping("/register")
	public String signup() {
		return "register";
	}
	@GetMapping("/about")
	public String about() {
		return "layout/about";
	}
	
	
	@RequestMapping("/product")
	public String list(Model model,@RequestParam(name = "keyword", required = false) String keyword) {
		 
		List<Product> list;
//		if (keyword != null && !keyword.isEmpty()) {
//	        list = productService.findByKeyword(keyword);
//	    } else {
	        list = productService.findAll();
	    
		model.addAttribute("items", list);
		//model.addAttribute("items", productDAO.findAll());
		return "product";
	}

	
	@RequestMapping("/cart")
	public String cart() {
		return "cart/gioHang";
	}
	
	@GetMapping("/chitietSP")
	public String chitietSP() {
		return "chitietSP";
	}
	
	@GetMapping("/productNew")
	public String productNew() {
		return "productNew";
	}
	
	@GetMapping("/productHot")
	public String productHot() {
		return "productHot";
	}
	
	@GetMapping("/spKhuyenMai")
	public String spKhuyenMai() {
		return "spKhuyenMai";
	}
	@Autowired
	BrandService brandservice;
	@RequestMapping("/thuongHieu")
	public String brand(Model model) {

		List<Brand> list = brandservice.findAll();

		model.addAttribute("brand_items", list);
		return "thuongHieu";
	}

	@GetMapping("/kienThucNuocHoa")
	public String kienThucNuocHoa() {
		return "kienThucNuocHoa";
	}
	
	@GetMapping("/reviewNuocHoa")
	public String reviewNuocHoa() {
		return "reviewNuocHoa";
	}
	
	@GetMapping("/tinTucNuocHoa")
	public String tinTucNuocHoa() {
		return "tinTucNuocHoa";
	}
	
	@GetMapping("/phanBietNuocHoa")
	public String phanBietNuocHoa() {
		return "phanBietNuocHoa";
	}
	
	@GetMapping("/uaChuong")
	public String uaChuong() {
		return "uaChuong";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "layout/contact";
	}
	@RequestMapping({ "/admin", "/admin/index" })
	public String admin() {
		return "redirect:/assets/admin/index.html";
	}
}
