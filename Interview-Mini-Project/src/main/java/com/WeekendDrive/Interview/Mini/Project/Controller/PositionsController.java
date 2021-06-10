package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

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

import com.WeekendDrive.Interview.Mini.Project.Bean.Positions;
import com.WeekendDrive.Interview.Mini.Project.Service.PositionService;


@RestController
@RequestMapping("/api/positions")
public class PositionsController
{
	@Autowired
	PositionService positionService;
	
	//Get All Position
	@GetMapping("/list")
	public List<Positions> getAllPositions()
	{
		return positionService.getAllPositions();
	}
	
	//Get Specific Data
	@GetMapping("/view/{id}")
	public Optional<Positions> getPositionById(@PathVariable("id") int id)
	{
		return positionService.getPositionById(id);
	}
	
	//Delete specific data
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Object> deletePosition(@PathVariable("id") int id)
	{
		positionService.deletePosition(id);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	// Create Data
	@PostMapping("/add")
	public ResponseEntity<Object> createPosition(@Validated @RequestBody Positions positions)
	{
		 positionService.createPosition(positions);
		 return new ResponseEntity<Object>(HttpStatus.ALREADY_REPORTED);
		
	}
	
	// Update Data
	@PutMapping("/update")
	public ResponseEntity<Object> updatePositions(@Validated @RequestBody Positions positions)
	{
		positionService.updatePosition(positions);
	    return new ResponseEntity<Object>(HttpStatus.ACCEPTED);	
	}
		
}
