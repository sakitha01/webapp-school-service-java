package com.school.app.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.app.schoolapp.model.StudentDetails;

@Repository
public interface StudentRepository extends JpaRepository<StudentDetails, Long> {

}
