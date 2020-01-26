package com.ksp1.service;

import com.ksp1.beans.User;

public interface UserService {

	User getByUsernamePassword(String userName, String password);

}
