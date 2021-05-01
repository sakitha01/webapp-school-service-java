package com.school.app.schoolapp.service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.school.app.schoolapp.model.Role;
import com.school.app.schoolapp.model.User;
import com.school.app.schoolapp.repository.RoleRepository;
import com.school.app.schoolapp.repository.UserRepository;
import com.school.app.schoolapp.utill.RoleName;

@Service
public class UserService {
	
	private RoleRepository roleRepository;
	private UserRepository userRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public UserService(UserRepository userRepository,RoleRepository roleRepository) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
	}

	public User reg(@Valid User user) {
		 Role userRole = roleRepository.findByName(RoleName.ROLE_USER);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		Set<Role> roles = Stream.of(userRole)
                .collect(Collectors.toCollection(HashSet::new));
		user.setRoles(roles);
		return userRepository.save(user);
	}

	public User updateUserDetails(long userId, User user) {
		if(userRepository.findById(userId).isPresent()) {
			
		}
		 return null;
	
	}

}
