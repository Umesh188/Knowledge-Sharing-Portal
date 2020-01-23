package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import com.ksp1.beans.Question;

public interface QuestionService {

	void addQuestion(Question q);

	List<Question> showAllQuestion();

	Optional<Question> getById(int id);

}
