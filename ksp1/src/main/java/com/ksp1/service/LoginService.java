package com.ksp1.service;

import java.util.Optional;

import com.ksp1.beans.User;

public interface LoginService {

	Optional<User> AuthenticateRole(String nm, String pass);

}
