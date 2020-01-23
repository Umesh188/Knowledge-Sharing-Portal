package com.ksp1.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="login")
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
public class User 
{

	@Id
	@GeneratedValue
	private int user_id;
	private String username;
	private String password;
	private int role;
	private String first_name;
	private String last_name;

	
	public User() {
		super();
	}


	public User( String username, String password, int role, String first_name, String last_name) {
		super();
		
		this.username = username;
		this.password = password;
		this.role = role;
		this.first_name = first_name;
		this.last_name = last_name;
	}


	public int getUser_id() {
		return user_id;
	}


	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public String getFirst_name() {
		return first_name;
	}


	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}


	public String getLast_name() {
		return last_name;
	}


	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}


	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", username=" + username + ", password=" + password + ", role=" + role
				+ ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}

		
	
	
	
	
	
}
