package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	private RoundRepository repository;
	
	@GetMapping("/list")
	public List<Round> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/view/{id}")
	public Optional<Round> findById(@PathVariable int id){
		return repository.findById(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id){
		repository.deleteById(id);
		
	}
	
	
}
