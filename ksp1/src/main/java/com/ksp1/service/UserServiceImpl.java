package com.ksp1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.User;
import com.ksp1.dao.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	
	@Autowired
	UserRepository userRepository;

	@Override
	public User getByUsernamePassword(String userName, String password) {
		// TODO Auto-generated method stub
		return userRepository.getByUsernamePassword(userName,password);
	}
}
