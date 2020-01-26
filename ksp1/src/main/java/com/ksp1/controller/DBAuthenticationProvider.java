
package com.ksp1.controller;

import java.util.ArrayList;
import java.util.List;

import javax.activity.InvalidActivityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.ksp1.beans.User;
import com.ksp1.security.UserAuthority;
import com.ksp1.service.UserService;

@Configurable
@Service
public class DBAuthenticationProvider implements AuthenticationProvider {

	@Autowired(required = true)
	UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		User u = userService.getByUsernamePassword(userName, password);
		if(null != u) {
		UserAuthority authority = new UserAuthority();
		authority.setAuthority(u.getRole());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userName, password, authorities);
		
		return token;
		} else {
			throw new AuthenticationCredentialsNotFoundException("Invalid credentials");
		}
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
