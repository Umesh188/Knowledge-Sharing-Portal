package com.ksp1.service;

import java.util.List;
import java.util.Optional;

import com.ksp1.beans.Answers;

public interface AnswerService {

	void addAnswer(Answers a);

	Optional<List<Answers>> getAnswersByquestionId(int id);

}
