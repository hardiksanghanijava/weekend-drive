package com.weekend.drive.interview.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	
	public String storeFile(MultipartFile file, String filename) throws IOException;

	public Resource getReasourceIfExist(String fileName) throws IOException;

	public Object renameFile(String oldname, String newname) throws MalformedURLException, IOException;
}
