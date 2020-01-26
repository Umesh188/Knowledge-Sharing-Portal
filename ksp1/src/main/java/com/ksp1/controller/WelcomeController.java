package com.ksp1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ksp1.beans.Answers;
import com.ksp1.beans.Question;
import com.ksp1.beans.ReviewQuestionList;
import com.ksp1.beans.Subject;
import com.ksp1.beans.User;
import com.ksp1.service.AnswerService;
import com.ksp1.service.LoginService;
import com.ksp1.service.QuestionService;
import com.ksp1.service.ReviewQuestionListService;
import com.ksp1.service.SubjectService;
import com.ksp1.service.UserService;

@Controller
public class WelcomeController {

	@Autowired
	LoginService loginService;

	@Autowired
	QuestionService questionService;

	@Autowired
	SubjectService subjectService;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ReviewQuestionListService reviewQuestionListService;
	

	@RequestMapping("/")
	public String index() {
		System.out.println("In the login function \n\n\n\n");
		return "WelcomePage";
	}
	
	@RequestMapping("/Student/Login")
	public String forAllLogin() 
	{
		return "LoginPage";
	}

	
	

	@RequestMapping("/Student/Student/login")
	public RedirectView validate(HttpServletRequest req, @RequestParam("username") String nm,
			@RequestParam("password") String pass) {
		System.out.println("In the login Authenticate role \n\n\n\n" + nm + "password" + pass);
		Optional<User> U = loginService.AuthenticateRole(nm, pass);
		User u=U.get();
		req.getSession().setAttribute("user", u);
		
		/*
		 * int role = 0; if(U.isPresent()) { User DbUser=U.get(); role=DbUser.getRole();
		 * }
		 * 
		 * System.out.println(U); req.getSession().setAttribute("role",role);
		 * if(role==1) { return "AdminKSP"; } else if(role==2) { return "FacultyKSP"; }
		 * else if(role==3) { return "UserKSP"; } else { return "Error404"; }
		 */
		/*
		 * int role = U.getRole(); String name = U.getName(); String pas =
		 * U.getPassword(); // System.out.println(name+""+pas+""+u.getRole);
		 * System.out.println(U.getRole()); req.getSession().setAttribute("role1",
		 * U.getRole()); if (role == 1) { return "AdminKSP"; } else { return "userKSP";
		 * }
		 * 
		 */
		return new RedirectView("/Student/home");
	}

	@RequestMapping("/Student/home")
	public ModelAndView homePage() {
		List<Question> QueList = questionService.showAllQuestion();
		System.out.println(QueList);
		/*
		 * for(Question w: QueList) {
		 * w.setAns(answerService.getAnswersByquestionId(w.getId()).get()); }
		 */
		return new ModelAndView("HomePage", "Que", QueList);
		
	}
	
	@RequestMapping("/post_question")
	public ModelAndView PostQuestion() {
		List<Subject> SubjectList = subjectService.getAllSubject();
		System.out.println(SubjectList);
		return new ModelAndView("AskQuestion", "sub", SubjectList);
	}
//First the question is inserted into the Review list 
	@PostMapping(value = "/question_in_review")
	public RedirectView	 addQuestionToReview(HttpServletRequest req,@RequestParam("question") String que, @RequestParam("subject") String sub) {
		//User U=req.getSession().getAttribute(user);
		ReviewQuestionList q = new ReviewQuestionList(que, sub);
		reviewQuestionListService.addQuestion(q);
		List<Question> QueList = questionService.showAllQuestion();

		return new RedirectView("/home");
		// return new ModelAndView("UserHome","Que",QueList);
	}
	
	
	//shows the page to review the questions which users have  posted
	@PostMapping(value = "/review_question_list")
	public ModelAndView	 showAllQuestionsToReview() {
		//User U=req.getSession().getAttribute(user);
		
		
		List<ReviewQuestionList> ReviewQueList = reviewQuestionListService.showAllQuestionToReview();

		return new ModelAndView("QuestionToReview","reviewQuestion",ReviewQueList);
		// return new ModelAndView("UserHome","Que",QueList);
	}
	
	
	

	
	@PostMapping(value = "/AskedQuestion")
	public RedirectView	 ViewAllQuestions(HttpServletRequest req,@RequestParam("question") String que, @RequestParam("subject") String sub) {
		//User U=req.getSession().getAttribute(user);
		Question q = new Question(que, sub);
		questionService.addQuestion(q);
		List<Question> QueList = questionService.showAllQuestion();

		return new RedirectView("/home");
		// return new ModelAndView("UserHome","Que",QueList);
	}

	@RequestMapping("/Student/post_answer")
	public ModelAndView postAnswerWithId(@RequestParam("id") int id) {
		Question q=questionService.getById(id).get();
		return new ModelAndView("PostAnswer1","question", q);
	}
	
	//method for adding the accepted question into the  
	@RequestMapping("/accept_question")
	public ModelAndView addAcceptedAnswer(@RequestParam("id") int id) {
		ReviewQuestionList q=reviewQuestionListService.getById(id).get();
		Question q2=new Question();
		q2.setQuestion(q.getQuestion());
		q2.setSubject(q.getSubject());
		//added the accepted question to question list to show all
		questionService.addQuestion(q2);
		reviewQuestionListService.deleteById(q);
		return new ModelAndView("PostAnswer","questionid", id);
	}
	
	
	
	
	@RequestMapping("/posted_answer")
	public RedirectView postAnswer(@RequestParam("answer") String answer,@RequestParam("questionid") int id) {
		Optional<Question> que=questionService.getById(id);
		if(que.isPresent())
		{
		Answers A=new Answers( answer, que.get());
	    answerService.addAnswer(A);
		 return new RedirectView("/home");
		}
		else
		{
			return new RedirectView("/home");
		}
	}

}
