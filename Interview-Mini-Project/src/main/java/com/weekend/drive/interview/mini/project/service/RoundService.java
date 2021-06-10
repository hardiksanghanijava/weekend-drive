package com.weekend.drive.interview.mini.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Exception.RoundNotFoundException;
import com.weekend.drive.interview.mini.project.bean.Round;
import com.weekend.drive.interview.mini.project.repository.RoundRepository;

import ccom.weekend.drive.interview.mini.project.request.RoundRequest;

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
			throw new RoundNotFoundException("Round : " + id + " not found");
		}
		logger.info("The method retreived by id {} is {}",id,round);
		return round;
	}
	
	//method to delete the rounds by specific id
	public void deleteRound( int id){
		Optional<Round> round = getRoundById(id);
		
		logger.info("Deleted round is{}",round);
		roundRepository.deleteById(id);
		
		}
	
	
 
	//method to update the rounds by specific id
	public void updateRound( int id, RoundRequest roundRequest){
		Round updatedRound = getRoundById(id).get();
		
		if(roundRequest.getName() != null) {
			updatedRound.setName(roundRequest.getName());
		}
		if(roundRequest.getSequence() != 0)
		updatedRound.setSequence(roundRequest.getSequence());
		roundRepository.save(updatedRound);
		logger.info("The updated fields are{}",updatedRound);
		
		
	}
	
	
	
}
