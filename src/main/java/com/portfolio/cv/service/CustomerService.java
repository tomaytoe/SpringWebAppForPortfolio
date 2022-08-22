package com.portfolio.cv.service;

import com.portfolio.cv.entity.Customer;
import com.portfolio.cv.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	@Autowired private CustomerRepository repo;

	public void addUser(Customer user){
		repo.save(user);
	}
}