package com.poly.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.dao.OrderDAO;
import com.poly.dto.DoanhThuTheoThang;
import com.poly.entity.Account;
import com.poly.entity.Order;
import com.poly.entity.Product;
import com.poly.service.AccountService;
import com.poly.service.OrderDetailService;
import com.poly.service.OrderService;
import com.poly.service.ProductService;

@Controller

public class ThongKeController {

    @Autowired
    private OrderDAO orderRepository;
    
    @Autowired
	AccountService accountService;
    
    @Autowired
	ProductService productService;
    
    @Autowired
	OrderService orderService;
    
    @Autowired
	OrderDetailService orderDetaiService;
    
    @GetMapping("/doanhthu")
    public String thongKeDoanhThu(Model model,
                                  @RequestParam(required = false) Integer nam,
                                  @RequestParam(required = false) Integer thang,
                                  @RequestParam(required = false) Integer ngay) {

        List<DoanhThuTheoThang> doanhThuTheoThangs;
        List<Account> customers = accountService.findAll();
        List<Product> product = productService.findAll();
        
     // Lấy danh sách top 5 sản phẩm bán nhiều nhất
        List<Object[]> topProducts = orderDetaiService.getTopSoldProducts();
     // Chỉ lấy ra 5 sản phẩm đầu tiên nếu danh sách lớn hơn 5
        List<Object[]> top5Products = topProducts.subList(0, Math.min(topProducts.size(), 5));

     // Lấy danh sách hóa đơn trong tháng hiện tại
        int currentMonth = java.time.LocalDate.now().getMonthValue();
        List<Order> orders = orderService.getOrdersByMonth(currentMonth);
        
        if (ngay != null) {
            // Thống kê theo ngày
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoNgay(nam, thang, ngay);
        } else if (thang != null) {
            // Thống kê theo tháng
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoThang(nam, thang);
        } else if (nam != null){
            // Thống kê theo năm
            doanhThuTheoThangs = orderRepository.thongKeDoanhThuTheoNam(nam);
        }else {
        	doanhThuTheoThangs = orderRepository.thongKeDoanhThu();
        }
        
     // Tính tổng số hóa đơn
        int orderCount = orders.size();
        int customerCount = customers.size();
        int products = product.size();
        
     // Truyền danh sách sản phẩm vào template Thymeleaf
        model.addAttribute("topProducts", top5Products);
        model.addAttribute("orderCount", orderCount);
        model.addAttribute("products", products);
        model.addAttribute("customerCount", customerCount);
        model.addAttribute("doanhThuTheoThangs", doanhThuTheoThangs);

        return "doanhthu";
    }
}


