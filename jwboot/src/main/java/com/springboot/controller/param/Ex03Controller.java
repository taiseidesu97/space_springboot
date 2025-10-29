package com.springboot.controller.param;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.dto.User;

@Controller
public class Ex03Controller {
	
	@GetMapping("/userForm")
	public String formPage() {
		return "pages/userForm";
	}
	
	@PostMapping("/login")
	public String resultPage(@ModelAttribute User user) {
		System.out.println("user: " + user);
		return"redirect:/";
	}
}
