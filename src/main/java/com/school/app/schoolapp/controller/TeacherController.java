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
import com.school.app.schoolapp.model.Teacher;
import com.school.app.schoolapp.response.AppResponse;
import com.school.app.schoolapp.service.TeacherService;
import com.school.app.schoolapp.utill.AppConstants;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;
	
	ObjectMapper objectMapper = new ObjectMapper();
	
	@RequestMapping(value = "/create_teacher", method = RequestMethod.POST)
	public AppResponse createTeacher(@RequestBody Teacher teachJson)
			throws JsonParseException, JsonMappingException, IOException {
		//Teacher teacher = objectMapper.readValue(teachJson, Teacher.class);
		teacherService.createTeacher(teachJson);

		return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
	}
	

}
