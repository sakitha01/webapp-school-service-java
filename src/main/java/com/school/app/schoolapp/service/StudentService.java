package com.school.app.schoolapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.school.app.schoolapp.model.StudentDetails;

public interface StudentService {

	StudentDetails createStudent(StudentDetails student);

	List<StudentDetails> getAllStudents();

	StudentDetails executeeditsave(StudentDetails student);


}
