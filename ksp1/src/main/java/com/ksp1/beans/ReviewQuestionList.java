package com.ksp1.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;

import com.ksp1.service.AnswerService;


@Entity
public class ReviewQuestionList {
	
	
	@Id
	@GeneratedValue
	private int id;
	private String question;
	private String subject;
	
	
	//private User user;
/*
 * public User getUser() { return user; }
 * 
 * public void setUser(User user) { this.user = user; }
 */
	
	@OneToMany( fetch = FetchType.EAGER, cascade = CascadeType.ALL ,mappedBy ="que" )
	private List<Answers> ans;

	
	public ReviewQuestionList()
	{
		super();
	}


	public ReviewQuestionList(String question, String subject) {
		super();
		
		this.question = question;
		this.subject = subject;

		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}




	public List<Answers> getAns() {
		return ans;
	}


	public void setAns(List<Answers> ans) {
		this.ans = ans;
	}


	@Override
	public String toString() {
		return "ReviewQuestionList [id=" + id + ", question=" + question + ", subject=" + subject + "]";
	}
	
	
	

}
