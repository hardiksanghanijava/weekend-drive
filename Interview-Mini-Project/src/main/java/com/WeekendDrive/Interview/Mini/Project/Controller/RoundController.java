package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.WeekendDrive.Interview.Mini.Project.Bean.Round;
import com.WeekendDrive.Interview.Mini.Project.Service.RoundService;

@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	@Autowired
	private RoundService service;
	
	//method to retrieve all the rounds	
	@GetMapping("/list")
	public List<Round> retrieveAll(){
		return service.findAll();
	}
	
	//method to retrieve the rounds by specific id	
	@GetMapping("/view/{id}")
	public Optional<Round> retrieveById(@PathVariable int id){
	
		return service.findById(id);
	}
	
	//method to delete the rounds by specific id	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Object> deleteById(@PathVariable int id){
		return service.deleteById(id);
	}
	
	//method to update the rounds by specific id
    @PostMapping("/update/{id}")
	public  ResponseEntity<Object> updateById(@Valid @PathVariable int id, @RequestBody Round round){
		return service.updateById(id, round);
		
	}
	
	
	
}
