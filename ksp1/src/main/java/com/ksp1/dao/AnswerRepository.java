package com.ksp1.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ksp1.beans.Answers;
@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer> {

	
	@Query("select a from Answers a where a.que=:qid ")
	Optional<List<Answers>> getAnswersByquestionId(@Param("qid")int qid);

}
