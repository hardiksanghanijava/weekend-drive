package 
com.weekend.drive.interview.service.impl;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.bean.Positions;
import com.weekend.drive.interview.exception.PositionsNotFoundException;
import com.weekend.drive.interview.repository.PositionsRepository;

@Service
public class PositionService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private PositionsRepository positionRepository;
	
	//get all data
	public List<Positions> getAllPositions(){
		List<Positions> positions =  positionRepository.findAll();
		logger.info("Get all Position: ",positions);
		return positions;
	}
	
	//get particular data
	public Optional<Positions> getPositionById(int id){
		Optional<Positions> positions = positionRepository.findById(id);
		if(positions.isEmpty())
			throw new PositionsNotFoundException("Position : " + id + " not found");
		logger.info("Get Position By Id: ",positions);
		return positions;
	}
	
	//create Data
	public void createPosition(Positions positions) {
		Optional<Positions> position = positionRepository.findById(positions.getId());
		if(position.isPresent())
		positionRepository.save(positions);
		logger.info("Create Position: ",positions);
	}
	
	//delete Data
	public void deletePosition(int id) {
		Optional<Positions> positions = positionRepository.findById(id);
		if(positions.isEmpty())
			throw new PositionsNotFoundException("Id : " + id);
		else
			logger.info("Delete Position: ",positions);
			positionRepository.deleteById(id);
	}
	
	//update Data
	public void updatePosition(Positions positions) {
		Optional<Positions> position = positionRepository.findById(positions.getId());
		if(position.isPresent()) {
			positionRepository.save(positions);
			logger.info("Update Position: ",position);
		}
		else
			logger.info("Update Fails: ",position);
		}
}
