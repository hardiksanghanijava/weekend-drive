package com.WeekendDrive.Interview.Mini.Project.Bean.Round;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	@Autowired
	private RoundRepository repository;
	
	@GetMapping("/list")
	public List<Round> findAll(){
		return repository.findAll();
	}
	
	@GetMapping("/view/{id}")
	public Optional<Round> findById(@PathVariable int id){
	
		Optional<Round> round = repository.findById(id);
		if(!round.isPresent()) {
			throw new RoundNotFoundException("id"+id);
		}
		return round;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteById(@PathVariable int id){
		repository.deleteById(id);
		
	}
	
/*  @PostMapping("/update/{id}")
	public void updateById(@PathVariable int id, @RequestBody Round round){
		Optional<Round> round1 = repository.findById(id);
		if(!round1.isPresent()) {
			throw new RoundNotFoundException("id"+id);
		}
		round1. (round.getName());
		round1.setSequence(round.getSequence());
	}*/
	
	@PostMapping("/update/{id}")
	public void updateById(@PathVariable int id, @RequestBody Round round){
		Optional<Round> round1 = repository.findById(id);
		if(!round1.isPresent()) {
			throw new RoundNotFoundException("id"+id);
		}
		repository.save(round);
		
	}
	
}
