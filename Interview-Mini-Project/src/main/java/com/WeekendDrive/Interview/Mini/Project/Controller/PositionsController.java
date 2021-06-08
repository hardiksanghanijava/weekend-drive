package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
	PositionService service;
	
	//Get All Data
	@GetMapping("/list")
	public List<Positions> retriveAllData()
	{
		return service.findAll();
	}
	
	//Get Specific Data
	@GetMapping("/view/{id}")
	public Optional<Positions> getParticularData(@PathVariable("id") int id)
	{
		return service.findById(id);
	}
	
	//Delete specific data
	@DeleteMapping("delete/{id}")
	public void deleteData(@PathVariable("id") int id)
	{
		service.deleteById(id);
	}
	
	// Create Data
	@PostMapping("/add")
	public ResponseEntity<Object> createData(@Validated @RequestBody Positions positions)
	{
		return service.createData(positions);
		
	}
	
	// Create Data
	@PutMapping("/update")
	public ResponseEntity<Object> updateData(@Validated @RequestBody Positions positions)
	{
			return service.updateData(positions);
			
	}
		
}
