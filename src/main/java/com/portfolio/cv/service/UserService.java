package com.portfolio.cv.service;

import com.portfolio.cv.entity.Customer;
import com.portfolio.cv.entity.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
	@Autowired private CustomerRepository repo;

	public void addUser(Customer user){
		repo.save(user);
	}

	public List<Customer> listAll(){
		return (List<Customer>) repo.findAll();
	}
}