package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Bean.Positions;
import com.WeekendDrive.Interview.Mini.Project.Exception.PositionsNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.PositionsRepo;

@Service
public class PositionService {


	@Autowired
	private PositionsRepo repo;
	
	//get all data
	public List<Positions> findAll(){
		return repo.findAll();
	}
	
	//get particular data
	public Optional<Positions> findById(int id){
		Optional<Positions> positions = repo.findById(id);
		if(positions.isEmpty())
			throw new PositionsNotFoundException("Id : " + id);
		return positions;
	}
	
	//create Data
	public ResponseEntity<Object> createData(Positions positions) {
		Optional<Positions> position = repo.findById(positions.getId());
		if(position.isPresent())
			return new ResponseEntity<Object>(HttpStatus.ALREADY_REPORTED);
		repo.save(positions);
		return new ResponseEntity<Object>(HttpStatus.CREATED);
	}
	
	//delete Data
	public void deleteById(int id) {
		Optional<Positions> positions = repo.findById(id);
		if(positions.isEmpty())
			throw new PositionsNotFoundException("Id : " + id);
		else
			repo.deleteById(id);
	}
	
	//update Data
	public ResponseEntity<Object> updateData(Positions positions) {
		Optional<Positions> p = repo.findById(positions.getId());
		if(p.isPresent()) {
			repo.save(positions);
			return new ResponseEntity<Object>(HttpStatus.ACCEPTED);
		}
		else
			return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
	}
}
