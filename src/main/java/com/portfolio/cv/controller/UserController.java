package com.portfolio.cv.controller;

import com.portfolio.cv.entity.User;
import com.portfolio.cv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController{
	@Autowired private UserService service;

	@GetMapping("/index")
	public String showIndex(){
		User user = new User();
		user.setEmail("envagyoktamas@gmail.com");
		user.setFirst_name("Tamas");
		user.setLast_name("Fulop");
		user.setPassword("4321");

		service.addUser(user);
		return "index";
	}
	
}