package com.weekend.drive.interview.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.weekend.drive.interview.service.FileStorageService;

@Service
public class FileStorageServiceImpl implements FileStorageService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	private Path fileStorageLocation ;
	
	@Value("${interview.mini.project.image.path}")
	private String getPath;
	
	
	@Override
	public String storeFile(MultipartFile file, String filename) throws IOException {
		if(file.isEmpty())
			return null;
		
		String fileName = String
				.format(filename + "." + file.getOriginalFilename().split("\\.")[1]);
		
		fileStorageLocation = Paths.get(getPath, fileName);	
		Files.write(fileStorageLocation, file.getBytes());
		logger.info("File Stored Successfully");
		
		return fileName;
		
	}
	
	@Override
	public Resource getReasourceIfExist(String fileName) throws IOException {
		Resource resource = null;
		String[] supportedFileExtension = {"jpg", "jpeg", "png", "bmp", "gif", "dng"};
		
		for (String extension : supportedFileExtension) {	
			Path filePath = Paths.get(getPath, fileName + "." + extension);
			resource = new UrlResource(filePath.toUri());
				if (resource != null) {
					if (resource.exists()) {
						return resource;
					}
				}
		}
					
		return resource;
	}
	

	@Override
	public Object renameFile(String oldname, String newname) throws IOException {

		Resource resource = getReasourceIfExist(oldname);
		String extension = resource.getURI().toString().split("\\.")[1];
		
		Path source = Paths.get(resource.getURI());
		Path copy = Paths.get(getPath, newname + "." + extension);

		Files.copy(source, copy);
		Files.delete(source);
		
		logger.info("File Renamed Successfully");
		
		return newname;	
	}

	

}
