package com.school.app.schoolapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.school.app.schoolapp.model.StudentDetails;
import com.school.app.schoolapp.response.AppResponse;
import com.school.app.schoolapp.service.FileStorageService;
import com.school.app.schoolapp.service.StudentService;
import com.school.app.schoolapp.utill.AppConstants;

@RestController
public class StudentController {

	ObjectMapper objectMapper = new ObjectMapper();

	
	  @Autowired FileStorageService fileStorageService;
	 

	@Autowired
	StudentService studentService;

	@RequestMapping(value = "/create_student", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public AppResponse createStudent(@RequestParam(value = AppConstants.STUDENT_JSON_PARAM) String studJson,
			@RequestParam(required = true, value = AppConstants.STUDENT_FILE_PARAM) MultipartFile file)
			throws JsonParseException, JsonMappingException, IOException {
		 String fileName = fileStorageService.storeFile(file); 
		
		  String fileDownloadUri =
		  ServletUriComponentsBuilder.fromCurrentContextPath().path(AppConstants.
		  DOWNLOAD_PATH) .path(fileName).toUriString();
		 

		StudentDetails student = objectMapper.readValue(studJson, StudentDetails.class);
		student.setProfilePicPath(fileDownloadUri);
		studentService.createStudent(student);

		return new AppResponse(AppConstants.SUCCESS_CODE, AppConstants.SUCCESS_MSG);
	}

	
	  @RequestMapping(value = "/downloadFile/{fileName:.+}", method =
	  RequestMethod.GET) public ResponseEntity<Resource> downloadFile(@PathVariable
	String fileName, HttpServletRequest request) {
		Resource resource = fileStorageService.loadFileAsResource(fileName);
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (contentType == null) {
			contentType = AppConstants.DEFAULT_CONTENT_TYPE;
		}
		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION,
						String.format(AppConstants.FILE_DOWNLOAD_HTTP_HEADER, resource.getFilename()))
				.body(resource);
	}
	 

	@GetMapping("/all_students")
	public ResponseEntity<List<StudentDetails>> getAllStudents() {
		return new ResponseEntity<List<StudentDetails>>(studentService.getAllStudents(), HttpStatus.CREATED);

	}

}
