package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.Question;
import com.ksp1.dao.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	QuestionRepository questionRepository; 
	
	@Override
	public void addQuestion(Question q) {
		questionRepository.save(q);
		
	}

	@Override
	public List<Question> showAllQuestion() {
		
		return questionRepository.findAll();
	}

	@Override
	public Optional<Question> getById(int id) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id);
	}

}
