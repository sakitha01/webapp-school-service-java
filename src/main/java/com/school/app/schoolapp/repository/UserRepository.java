package com.school.app.schoolapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.app.schoolapp.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByFirstName(String username);

	User findByEmail(String email);

}
