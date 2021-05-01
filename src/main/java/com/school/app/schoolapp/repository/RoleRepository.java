package com.school.app.schoolapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.app.schoolapp.model.Role;
import com.school.app.schoolapp.utill.RoleName;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Role findByName(RoleName roleUser);

	List<Role> findByUsers_FirstName(String firstName);

}
