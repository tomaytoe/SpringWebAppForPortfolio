package com.portfolio.cv.controller;

import com.portfolio.cv.entity.Customer;
import com.portfolio.cv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController{
	@Autowired private UserService service;

	@GetMapping("/")
	public String showIndex(){
		Customer user = new Customer();
		user.setEmail("envagyoknoemi@gmail.com");
		user.setFirst_name("Noemi");
		user.setLast_name("Szepfalusi");
		user.setPassword("4321");

		service.addUser(user);

		return "index";
	}
	
}