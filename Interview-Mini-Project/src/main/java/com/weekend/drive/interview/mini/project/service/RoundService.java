package com.weekend.drive.interview.mini.project.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.mini.project.bean.Round;
import com.weekend.drive.interview.mini.project.exception.RoundNotFoundException;
import com.weekend.drive.interview.mini.project.repository.RoundRepository;
import com.weekend.drive.interview.mini.project.request.RoundUpdateRequest;
import com.weekend.drive.interview.mini.project.response.RoundResponse;


@Service
public class RoundService {
	
	Logger logger= LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoundRepository roundRepository;
	
	//method to retrieve all the rounds	
	public List<RoundResponse> getAllRounds(){
		List<Round> rounds= roundRepository.findAll();
		List<RoundResponse> roundResponse = new ArrayList<>();
		for(Round round: rounds) {
			roundResponse.add(new RoundResponse(round.getId(),round.getName(),round.getSequence()));
		}
		logger.info("All the retrieved methods are{}",roundResponse);
		return roundResponse;
	}
	
	//method to retrieve the rounds by specific id	
	public RoundResponse getRoundById( int id) throws IllegalAccessException, InvocationTargetException{
	
		Round round = roundRepository.findById(id).get();
		if(round.equals(null)) {
			throw new RoundNotFoundException("Round : " + id + " not found");
		}
		RoundResponse roundResponse= round.toRoundEntityResponse(round);
		logger.info("The method retreived by id {} is {}",id,roundResponse);
		return roundResponse;
	}
	
	//method to delete the rounds by specific id
	public void deleteRound( int id) throws IllegalAccessException, InvocationTargetException{
		RoundResponse round = getRoundById(id);
		
		logger.info("Deleted round is{}",round);
		roundRepository.deleteById(id);
		
		}
	
	
 
	//method to update the rounds by specific id
	public void updateRound( int id, RoundUpdateRequest roundUpdateRequest) throws IllegalAccessException, InvocationTargetException{
		RoundResponse updatedRound = getRoundById(id);
		
		if(roundUpdateRequest.getName() != null) {
			updatedRound.setName(roundUpdateRequest.getName());
		}
		if(roundUpdateRequest.getSequence() != 0)
		updatedRound.setSequence(roundUpdateRequest.getSequence());
		roundRepository.save(updatedRound);
		logger.info("The updated fields are{}",updatedRound);
		
		
	}
	
	
	
}
