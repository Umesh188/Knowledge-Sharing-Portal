
package com.ksp1.beans;

import javax.persistence.Entity;


@Entity
public class Faculty extends User
{
	
	
	
	public Faculty() {
		super();
	}

	public Faculty(String username, String password, int role, String first_name, String last_name) {
		super(username, password, role,first_name,last_name);
		
	}

	@Override
	public String toString() {
		return super.toString();
	}

	
}
