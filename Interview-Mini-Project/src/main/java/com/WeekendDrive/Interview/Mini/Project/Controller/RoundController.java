package com.WeekendDrive.Interview.Mini.Project.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private RoundService roundService;
	
	//method to retrieve all the rounds	
	@GetMapping("/list")
	public List<Round> getAllRounds(){
		return roundService.getAllRounds();
	}
	
	//method to retrieve the rounds by specific id	
	@GetMapping("/view/{id}")
	public Optional<Round> getRoundById(@PathVariable int id){
	
		return roundService.getRoundById(id);
	}
	
	//method to delete the rounds by specific id	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<Object> deleteRound(@PathVariable int id){
		roundService.deleteRound(id);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
	}
	
	//method to update the rounds by specific id
    @PostMapping("/update/{id}")
	public  ResponseEntity<Object> updateRound(@Valid @PathVariable int id, @RequestBody Round round){
		roundService.updateRound(id, round);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		
	}
	
	
	
}
