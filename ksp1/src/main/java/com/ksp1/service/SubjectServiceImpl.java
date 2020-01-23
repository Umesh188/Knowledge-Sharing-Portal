package com.ksp1.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ksp1.beans.Subject;
import com.ksp1.dao.SubjectRepository;
@Service
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	SubjectRepository subjectRepository;
	@Override
	public List<Subject> getAllSubject() {
		
		return subjectRepository.findAll();
	}

}
