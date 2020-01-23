package com.ksp1.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ksp1.beans.Question;

public interface QuestionRepository extends JpaRepository<Question, Integer> {

}
