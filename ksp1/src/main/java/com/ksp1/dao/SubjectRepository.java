package com.ksp1.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ksp1.beans.Subject;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
