package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.Answers;
import com.ksp1.dao.AnswerRepository;
@Service
public class AnswerServiceImpl implements AnswerService {

	@Autowired
	AnswerRepository answerRepository;
	@Override
	public void addAnswer(Answers a) {
		
		answerRepository.save(a);
	}
	@Override
	public Optional<List<Answers>> getAnswersByquestionId(int id) {
		return answerRepository.getAnswersByquestionId(id);
	}

}
