package com.ksp1.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Subject {

	@Id
	@GeneratedValue
	private int id;
	private String Subject;
	
	public Subject() {
		super();
	}

	public Subject(int id, String subject) {
		super();
		this.id = id;
		Subject = subject;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return Subject;
	}

	public void setSubject(String subject) {
		Subject = subject;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", Subject=" + Subject + "]";
	}
	
	
	
}
