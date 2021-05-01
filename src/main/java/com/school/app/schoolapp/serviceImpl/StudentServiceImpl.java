package com.school.app.schoolapp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.school.app.schoolapp.model.StudentDetails;
import com.school.app.schoolapp.repository.StudentRepository;
import com.school.app.schoolapp.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepository studentRepository;

	@Override
	public StudentDetails createStudent(StudentDetails student) {
		return studentRepository.save(student);
		
	}

	@Override
	public List<StudentDetails> getAllStudents() {
		return studentRepository.findAll();
	}

}
