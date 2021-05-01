package com.school.app.schoolapp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.school.app.schoolapp.utill.AppConstants;

@ConfigurationProperties(prefix = AppConstants.FILE_PROPERTIES_PREFIX)
public class FileStorageProperties {
	private String uploadDir;

	public String getUploadDir() {
		return uploadDir;
	}

	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
