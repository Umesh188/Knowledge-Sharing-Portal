
  package com.ksp1.beans;

import javax.persistence.Entity;

@Entity
  public class Admin extends User{
  
		
		public Admin() {
			super();
		}
		

		public Admin(String username, String role, String password, String first_name, String last_name) {
			super(username, password, role,first_name,last_name);
		}


		@Override
		public String toString() {
			return super.toString();
		}
	
		
		
  }
 