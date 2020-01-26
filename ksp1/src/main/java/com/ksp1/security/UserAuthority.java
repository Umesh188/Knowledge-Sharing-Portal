package com.ksp1.security;

import org.springframework.security.core.GrantedAuthority;

public class UserAuthority implements GrantedAuthority {
	
	String authority;
	
	public void setAuthority(String authority) {
		this.authority = authority;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return authority;
	}
	
	

}
