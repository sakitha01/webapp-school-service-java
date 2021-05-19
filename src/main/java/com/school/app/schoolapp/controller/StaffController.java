package com.school.app.schoolapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.app.schoolapp.model.Staff;
import com.school.app.schoolapp.response.AppResponse;
import com.school.app.schoolapp.service.StaffService;
import com.school.app.schoolapp.utill.AppConstants;

@RestController
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value = "/create_staff", method = RequestMethod.POST)
	public AppResponse createStaff(@RequestBody Staff staffJson)
			throws JsonParseException, JsonMappingException, IOException {
		//Staff staff = objectMapper.readValue(staffJson, Staff.class);
		staffService.createStaff(staffJson);

		return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
	}
	

}
