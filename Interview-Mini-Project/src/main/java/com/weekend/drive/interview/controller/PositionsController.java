package com.weekend.drive.interview.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekend.drive.interview.request.PositionsRequest;
import com.weekend.drive.interview.request.PositionsUpdateRequest;
import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.service.impl.PositionServiceImpl;


@RestController
@RequestMapping("/api/positions")
public class PositionsController
{
	@Autowired
	PositionServiceImpl positionServiceImpl;
	
	//Get All Position
	@GetMapping("/list")
	public ResponseEntity<?> getAllPositions() {
		return new ResponseEntity<>(new ApiResponse<>(positionServiceImpl.getAllPositions(),
				"Get All Position Successfully :"), HttpStatus.ACCEPTED);
	}
	
	//Get Specific Data
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getPositionById(@PathVariable("id") int id) throws IllegalAccessException, InvocationTargetException
	{
		return new ResponseEntity<>(new ApiResponse<>(positionServiceImpl.getPositionById(id),
				"Get Position Successfully at this :"), HttpStatus.ACCEPTED);
	}
	
	//Delete specific data
	@DeleteMapping("delete/{id}")
	public ResponseEntity<?> deletePosition(@PathVariable int id) throws IllegalAccessException, InvocationTargetException{
		positionServiceImpl.deletePosition(id);
		return new ResponseEntity<>(new ApiResponse<>(id,
				"Position Deleted Successfully "), HttpStatus.ACCEPTED);
	}
	
	// Create Data
	@PostMapping("/add")
	public ResponseEntity<?> createPosition(@Validated @RequestBody PositionsRequest positionsRequest)
			throws IllegalAccessException, InvocationTargetException {
		return new ResponseEntity<>(new ApiResponse<>(positionServiceImpl.createPosition(positionsRequest).getId(),
				"Position Created Successfully at this :"), HttpStatus.CREATED);
	}

	
	// Update Data
	@PutMapping("/update")
	public ResponseEntity<?> updatePositions(@Validated @RequestBody PositionsUpdateRequest positionsUpdateRequest)throws IllegalAccessException, InvocationTargetException
	{
		return new ResponseEntity<>(new ApiResponse<>(positionServiceImpl.updatePosition(positionsUpdateRequest).getId(),
				"Position Updated Successfully at this :"), HttpStatus.ACCEPTED);
	}
		
}
