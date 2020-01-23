package com.ksp1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ksp1.beans.Answers;
import com.ksp1.beans.Question;
import com.ksp1.beans.Subject;
import com.ksp1.beans.User;
import com.ksp1.service.AnswerService;
import com.ksp1.service.LoginService;
import com.ksp1.service.QuestionService;
import com.ksp1.service.SubjectService;

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

	@RequestMapping("/")
	public String index() {
		System.out.println("In the login function \n\n\n\n");
		return "index";
	}

	@RequestMapping("/login")
	public RedirectView validate(HttpServletRequest req, @RequestParam("username") String nm,
			@RequestParam("pass") String pass) {
		System.out.println("In the login Authenticate role \n\n\n\n" + nm + "password" + pass);
		Optional<User> U = loginService.AuthenticateRole(nm, pass);
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
		return new RedirectView("/home");
	}

	@RequestMapping("/home")
	public ModelAndView homePage() {
		List<Question> QueList = questionService.showAllQuestion();
		System.out.println(QueList);
		/*
		 * for(Question w: QueList) {
		 * w.setAns(answerService.getAnswersByquestionId(w.getId()).get()); }
		 */
		return new ModelAndView("UserHome", "Que", QueList);
		
	}
	
	@RequestMapping("/post_question")
	public ModelAndView PostQuestion() {
		List<Subject> SubjectList = subjectService.getAllSubject();
		System.out.println(SubjectList);
		return new ModelAndView("AskQuestion", "sub", SubjectList);
	}

	@PostMapping(value = "/AskedQuestion")
	public RedirectView	 ViewAllQuestions(@RequestParam("question") String que, @RequestParam("subject") String sub) {
		Question q = new Question(que, sub);
		questionService.addQuestion(q);
		List<Question> QueList = questionService.showAllQuestion();

		return new RedirectView("/home");
		// return new ModelAndView("UserHome","Que",QueList);
	}

	@RequestMapping("/post_answer")
	public ModelAndView postAnswerWithId(@RequestParam("id") int id) {

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
