package com.school.app.schoolapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.school.app.schoolapp.model.AuthenticationRequest;
import com.school.app.schoolapp.model.AuthenticationResponse;
import com.school.app.schoolapp.model.User;
import com.school.app.schoolapp.security.CustomUserDetailService;
import com.school.app.schoolapp.service.UserService;
import com.school.app.schoolapp.utill.JwtTokenProvider;
@RestController
public class UserController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Autowired
	JwtTokenProvider jwtTokenProvider;
	
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	@PostMapping("/userreg")
	public User registerUser(@Valid @RequestBody User user) {
	    return userService.reg(user);
	}
	@PostMapping("/updateuser")
	public User updateUser(long userId ,@RequestBody User user) {
		return userService.updateUserDetails(userId,user);
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthJwtToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));

		}catch (BadCredentialsException e) {
			throw new Exception("Incorrect Username or password",e);
		}
		
		//final UserDetails userDetails = customUserDetailService.loadUserByUsername(authenticationRequest.getEmail());
		
		final String jwt = jwtTokenProvider.generateToken(authenticationRequest.getEmail());
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}
	
	
}
