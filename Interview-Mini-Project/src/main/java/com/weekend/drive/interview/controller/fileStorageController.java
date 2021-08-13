package com.weekend.drive.interview.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.service.FileStorageService;

@RestController
@CrossOrigin(origins="http://localhost:6868")
@RequestMapping("/api/upload/")
public class fileStorageController {

	@Autowired
	private FileStorageService fileStorageService;  
	
	//Upload Image with custom name
	@PostMapping("/image/{filename}")
	public ResponseEntity<?> storeImage(@RequestParam("file") MultipartFile file, @PathVariable String filename) throws IOException{
		return new ResponseEntity<>(new ApiResponse<>(fileStorageService.storeFile(file, filename),
				"Image Uploaded Successfully"), HttpStatus.OK);
	}
	
	//Rename existing Image
	@GetMapping("/image/rename/from/{oldname}/to/{newname}")
	public ResponseEntity<?> renameImage(@PathVariable String oldname,  @PathVariable String newname) throws IOException{
		return new ResponseEntity<>(new ApiResponse<>(fileStorageService.renameFile(oldname, newname),
				"Image Renamed Successfully"), HttpStatus.OK);
	}
}

	









