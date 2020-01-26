package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.Question;
import com.ksp1.beans.ReviewQuestionList;
import com.ksp1.dao.ReviewQuestionListRepository;

@Service
public class ReviewQuestionListServiceImpl implements ReviewQuestionListService {

	
	@Autowired
	ReviewQuestionListRepository reviewQuestionListRepository;
	
	
	@Override
	public void addQuestion(ReviewQuestionList q) {
		reviewQuestionListRepository.save(q);
		
	}


	@Override
	public List<ReviewQuestionList> showAllQuestionToReview() {
		// TODO Auto-generated method stub
		return reviewQuestionListRepository.findAll();
	}


	@Override
	public Optional<ReviewQuestionList> getById(int id) {
		
		return reviewQuestionListRepository.findById(id);
	}


	@Override
	public Object deleteById(ReviewQuestionList q) {
		// TODO Auto-generated method stub
		return null;/*reviewQuestionListRepository.delete(q);*/
	}


		
}


