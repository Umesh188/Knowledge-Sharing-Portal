package com.ksp1.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Answers {

	
	@Id
	@GeneratedValue
	private int ansId;
	
	private String answer;
	@ManyToOne
	private Question que;
	public Answers( String answer, Question que) {
		super();
		
		this.answer = answer;
		this.que = que;
	}
	public Answers() {
		super();
	}
	public int getAnsId() {
		return ansId;
	}
	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Question getQue() {
		return que;
	}
	public void setQue(Question que) {
		this.que = que;
	}
	@Override
	public String toString() {
		return "Answers [ansId=" + ansId + ", answer=" + answer + ", que=" + /* que */  "]";
	}
	
	
	
}
