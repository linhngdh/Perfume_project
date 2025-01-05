package com.poly.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.poly.entity.Order;
import com.poly.entity.OrderDetail;
import com.poly.service.OrderService;



@Controller
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/thanhToan";
	}

	@RequestMapping("/order/list")
	public String list(Model model,HttpServletRequest request) {
		String username =request.getRemoteUser();
		model.addAttribute("orders", orderService.findByUsername(username));
		return "order/list";
	}

	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id")Long id,Model model) {
		Order order = orderService.findById(id);
		Double thanhTien = 0.0;
		for(OrderDetail orderDetail : order.getOrderDetails())
		{
			thanhTien += orderDetail.getPrice() * orderDetail.getQuantity();
		}
		model.addAttribute("thanhTien", thanhTien);
		model.addAttribute("order", order);
		return "order/detail";
	}
	
	@PostMapping("/order/updateStatus/{id}")
    public String updateOrderStatus(@PathVariable Long id, @RequestParam String newStatus) {
        try {
            orderService.updateOrderStatus(id, newStatus);
        } catch (Exception e) {
            // Xử lý lỗi, ví dụ: hiển thị thông báo lỗi
        }
        return "redirect:/order/list"; // Chuyển hướng về danh sách đơn hàng sau khi cập nhật
    }
	

}
