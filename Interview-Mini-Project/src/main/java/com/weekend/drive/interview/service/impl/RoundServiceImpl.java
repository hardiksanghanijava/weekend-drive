package com.weekend.drive.interview.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.bean.Round;
import com.weekend.drive.interview.exception.RoundNotFoundException;
import com.weekend.drive.interview.repository.RoundRepository;
import com.weekend.drive.interview.request.RoundUpdateRequest;
import com.weekend.drive.interview.response.RoundResponse;
import com.weekend.drive.interview.service.RoundService;


@Service
public class RoundServiceImpl implements RoundService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private RoundRepository roundRepository;
	
	//method to retrieve all the rounds	
	@Override
	public List<RoundResponse> getAllRounds(){
		
		//Retrieving all round entities
		List<Round> rounds= roundRepository.findAll();
		List<RoundResponse> roundResponse = new ArrayList<>();

		//Iterating over Entity list to store in response list
		rounds.stream().forEach(round ->{
			try {
				roundResponse.add(Round.toRoundEntityResponse(round));
			} catch (IllegalAccessException e) {

				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		logger.info("All the retrieved methods are{}",roundResponse);
		return roundResponse;
	}
	
	//method to retrieve the rounds by specific id	
	@Override
	public RoundResponse getRoundById( int id) throws IllegalAccessException, InvocationTargetException{
	
		//Retrieving round by id
		Optional<Round> round = roundRepository.findById(id);
		//Checking if given id is present
		if(round.isEmpty())
			throw new RoundNotFoundException("Round : " + id + " not found");
		
		Round round2 = round.get();
		//Storing entity to response
		RoundResponse roundResponse= Round.toRoundEntityResponse(round2);
		logger.info("The method retreived by id {} is {}",id,roundResponse);
		return roundResponse;
	}
	
	//method to delete the rounds by specific id
	@Override
	public void deleteRound( int id) throws IllegalAccessException, InvocationTargetException{
		
		//Fetching and checking the round present at id
		RoundResponse round = getRoundById(id);
		
		logger.info("Deleted round is{}",round);
		roundRepository.deleteById(id);
		
		}
	
	
 
	//method to update the rounds by specific id
	@Override
	public Round updateRound(RoundUpdateRequest roundUpdateRequest) throws IllegalAccessException, InvocationTargetException{
		
		//Fetching and checking the round present at id
		 getRoundById(roundUpdateRequest.getId());
	
		 Round round = roundRepository.save(RoundUpdateRequest.toRoundRequestEntity(roundUpdateRequest));
		logger.info("The updated fields are{}",roundUpdateRequest);
		
		return round;
	}
	
	
	
}
