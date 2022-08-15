package com.portfolio.cv.service;

import com.portfolio.cv.entity.User;
import com.portfolio.cv.entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService{
	@Autowired private UserRepository repo;

	public void addUser(User user){
		repo.save(user);
	}

	public List<User> listAll(){
		return (List<User>) repo.findAll();
	}
}