package com.weekend.drive.interview.service.impl;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.bean.Positions;
import com.weekend.drive.interview.exception.PositionsNotFoundException;
import com.weekend.drive.interview.repository.PositionsRepository;
import com.weekend.drive.interview.request.PositionsRequest;
import com.weekend.drive.interview.request.PositionsUpdateRequest;
import com.weekend.drive.interview.response.PositionsResponse;
import com.weekend.drive.interview.service.PositionService;

@Service
public class PositionServiceImpl implements PositionService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PositionsRepository positionRepository;
	
	//get all data
	@Override
	public List<PositionsResponse> getAllPositions(){
		List<Positions> positions =  positionRepository.findAll();
		List<PositionsResponse> positionResponse = new ArrayList<>();
		for(Positions position: positions)
		{
			positionResponse.add(new PositionsResponse(position.getId(),position.getName(),position.getDescription()));
		}
 		logger.info("Get all Position: ",positionResponse);
		return positionResponse;
	}
	
	//get particular data
	@Override
	public PositionsResponse getPositionById(int id) throws IllegalAccessException, InvocationTargetException{
		Optional<Positions> positions = positionRepository.findById(id);
		
		if(positions.isEmpty())
			throw new PositionsNotFoundException("Position : " + id + " not found");
		
		Positions positions2 = positions.get();
		
		PositionsResponse positionsResponse = Positions.toPositionResponseEnttity(positions2);
		logger.info("Get Position By Id: ",positions);
		return positionsResponse;
	}
	
	//create Data
	@Override
	public Positions createPosition(PositionsRequest positionsRequest) throws IllegalAccessException, InvocationTargetException {
		Positions position = positionRepository.save(PositionsRequest.toPositionRequestEnttity(positionsRequest));
		logger.info("Created Resource : " + position);
		return position;
	}
	
	
	//delete Data
	@Override
	public void deletePosition(int id) throws IllegalAccessException, InvocationTargetException {
			getPositionById(id);
			positionRepository.deleteById(id);
	}
		
	//Update Data
	@Override
	public Positions updatePosition(PositionsUpdateRequest positionsUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		getPositionById(positionsUpdateRequest.getId());	
		Positions position = positionRepository.save(PositionsUpdateRequest.toPositionRequestEnttity(positionsUpdateRequest));
		logger.info("Position Updated : " + position);
		return position;
}
}
