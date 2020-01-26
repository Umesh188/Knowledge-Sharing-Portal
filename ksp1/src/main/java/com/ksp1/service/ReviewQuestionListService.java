package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import com.ksp1.beans.Question;
import com.ksp1.beans.ReviewQuestionList;

public interface ReviewQuestionListService {

	void addQuestion(ReviewQuestionList q);

	List<ReviewQuestionList> showAllQuestionToReview();

	Optional<ReviewQuestionList> getById(int id);

	Object deleteById(ReviewQuestionList q);

}
