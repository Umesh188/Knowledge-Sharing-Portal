package com.ksp1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksp1.beans.ReviewQuestionList;
@Repository
public interface ReviewQuestionListRepository extends JpaRepository<ReviewQuestionList, Integer> {

}
