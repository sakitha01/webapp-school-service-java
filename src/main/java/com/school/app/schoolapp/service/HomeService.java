package com.school.app.schoolapp.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.app.schoolapp.model.StudentDetails;
import com.school.app.schoolapp.repository.StudentRepository;

@Service
public class HomeService {
	
	StudentRepository studentRepository;
	
	public HomeService(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public StudentDetails reg(@Valid StudentDetails studentDetails) {
		return studentRepository.save(studentDetails);
	}

	public List<StudentDetails> getAllStudents() {
		return studentRepository.findAll();
	}

}
