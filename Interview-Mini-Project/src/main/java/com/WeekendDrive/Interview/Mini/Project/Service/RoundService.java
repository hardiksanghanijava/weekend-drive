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
	private RoundRepository roundRepository;
	
	//method to retrieve all the rounds	
	public List<Round> getAllRounds(){
		List<Round> rounds= new ArrayList<>();
		rounds=roundRepository.findAll();
		logger.info("All the retrieved methods are{}",rounds);
		return rounds;
	}
	
	//method to retrieve the rounds by specific id	
	public Optional<Round> getRoundById( int id){
	
		Optional<Round> round = roundRepository.findById(id);
		if(!round.isPresent()) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}
		logger.info("The method retreived by id {} is {}",id,round);
		return round;
	}
	
	//method to delete the rounds by specific id
	public void deleteRound( int id){
		Optional<Round> round = roundRepository.findById(id);
		if(!round.isPresent()) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}else {
		logger.info("Deleted round is{}",round);
		roundRepository.deleteById(id);
		
		}
	}
	
 
	//method to update the rounds by specific id
	public void updateRound( int id, Round round){
		Round updatedRound = roundRepository.findById(id).get();
		if(updatedRound.equals(null)) {
			throw new RoundNotFoundException("Round not found for id="+id);
		}
		if(round.getName() != null) {
			updatedRound.setName(round.getName());
		}
		if(round.getSequence() != 0)
		updatedRound.setSequence(round.getSequence());
		roundRepository.save(updatedRound);
		logger.info("The updated fields are{}",updatedRound);
		
		
	}
	
	
	
}
