package com.poly.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Account;
import com.poly.service.impl.AccountServiceImpl;
import com.poly.service.impl.AuthorityServiceImpl;

@Controller
public class SecurityController {
	@Autowired
    private AccountServiceImpl accountService;
	@Autowired
    private AuthorityServiceImpl authoService;
	
	@RequestMapping("/security/login/form")
	public String loginForm(Model model) {
		model.addAttribute("message", "Vui lòng đăng nhập");
		return "security/login";
	}

	@RequestMapping("/security/login/success")
	public String loginSuccess(Model model) {
		model.addAttribute("message", "Đăng nhập thành công!");
		return "index";
	}

	@RequestMapping("/security/login/error")
	public String loginError(Model model) {
		model.addAttribute("message","Sai thông tin đăng nhập!");
		return "security/login";
	}
	@RequestMapping("/security/logoff/success")
	public String logoffSucess(Model model) {
		model.addAttribute("message","Bạn đã đăng xuất thành công!");
		return "security/login";
	}
	
	@GetMapping("/register")
    public String register(Model model) {
    	model.addAttribute("title", "Register Pages");
    	model.addAttribute("account", new Account());
    	return "security/register";
    }
	
	@PostMapping("/register-new")
    public String newUser(@Valid @ModelAttribute("account") Account account,
                          Model model,
                          BindingResult result) {
        try {
            if (result.hasErrors()) {
                model.addAttribute("account", account);
                return "security/register";
            }

            String username = account.getUsername();
            Account user = accountService.findByUsername(username);

            if (user != null) {
                model.addAttribute("account", account);
                System.out.println("Account not null");
                return "security/register";
            } else {
                // Gán giá trị trả về từ accountService.findByUsername(username) vào user
                user = accountService.findByUsername(username);

                // Thực hiện các xử lý tạo tài khoản ở đây, ví dụ:
                accountService.create(account);
//                authoService.create(1, "av", "dc");
                
                model.addAttribute("account", account);
                return "security/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "security/login";
    }
	

	@RequestMapping("/security/unauthoried")
	public String unauthoried(Model model) {
		model.addAttribute("message", "Không có quyền truy xuất");
		return "security/login";
	}
}
