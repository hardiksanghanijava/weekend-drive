package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.WeekendDrive.Interview.Mini.Project.Bean.Round;
import com.WeekendDrive.Interview.Mini.Project.Exception.RoundNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.RoundRepository;

@Service
public class RoundService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoundRepository repository;
	
	//method to retrieve all the rounds	
	public List<Round> findAll(){
		List<Round> round= new ArrayList<>();
		round=repository.findAll();
		logger.info("All the retrieved methods are{}",round);
		return round;
	}
	
	//method to retrieve the rounds by specific id	
	public Optional<Round> findById( int id){
	
		Optional<Round> round = repository.findById(id);
		if(!round.isPresent()) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}
		logger.info("The method retreived by id {} is {}",id,round);
		return round;
	}
	
	//method to delete the rounds by specific id
	public ResponseEntity<Object> deleteById( int id){
		Optional<Round> round = repository.findById(id);
		if(!round.isPresent()) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}else {
		
		repository.deleteById(id);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
	}
	
 
	//method to update the rounds by specific id
	public ResponseEntity<Object> updateById( int id, Round round){
		Round round1 = repository.findById(id).get();
		if(round1.equals(null)) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}
		if(round.getName() != null) {
			round1.setName(round.getName());
		}
		if(round.getSequence() != 0)
		round1.setSequence(round.getSequence());
		repository.save(round1);
		logger.info("The updated fields are{}",round1);
		return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		
	}
	
	
	
}
