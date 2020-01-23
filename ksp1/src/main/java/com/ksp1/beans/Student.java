
package com.ksp1.beans;


import javax.persistence.Entity;
@Entity
//@Embeddable
public class Student extends User {
	/*
	 * @Id
	 * 
	 * @GeneratedValue
	 */
	
	private int score;

	public Student() {
		super();
		this.score = 0;
	}

	public Student(String username, String password,int role, String first_name, String last_name, int score ) {
		super(username, password, role,first_name,last_name);
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return super.toString()+"Student [score=" + score + "]";
	}

	

}
