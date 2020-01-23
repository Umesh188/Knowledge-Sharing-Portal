package com.ksp1.service;



import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.User;
import com.ksp1.dao.LoginRepository;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepository loginRepository;
	@Override
	public Optional<User> AuthenticateRole(String nm, String pass) {
		System.out.println("in the login service\n\n\n\n");
		
		return loginRepository.AuthenticateRole(nm,pass);
	}

}
