package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Exception.IntervieweeNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.ScheduleInterviewRepository;

@Service
public class ScheduleInterviewService {

	@Autowired
	private ScheduleInterviewRepository scheduleinterviewRepository;
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//Retrieve all scheduled interview
	public List<ScheduleInterview> getAllScheduleInterview(){
		List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
		log.info("All Retieved Records : " + scheduleInterview);
		return scheduleInterview;
	}
	
	//Retrieve scheduled interview by id
	public Optional<ScheduleInterview> getScheduleInterviewById(int id){
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		log.info("Find record by id : " + scheduleInterview);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Foud");
		return scheduleInterview;
	}
	
	//Create new scheduled interview
	public void createScheduleInterview(ScheduleInterview scheduleInterview) {
		ScheduleInterview saveScheduleInterview = scheduleinterviewRepository.save(scheduleInterview);
		log.info("Created Resource : " + saveScheduleInterview);
	}
	
	//Delete scheduled interview by id
	public void deleteScheduleInterview(int id) {
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Found");
		else {
			log.info("Deleted resource : " + scheduleInterview);
			scheduleinterviewRepository.deleteById(id);
		}
	}
	
	//Update existing scheduled interview
	public void updateScheduleInterview(int id, ScheduleInterview scheduleInterview) {
		Optional<ScheduleInterview> oldScheduleInterview = scheduleinterviewRepository.findById(id);
		if(oldScheduleInterview.isPresent()) {
			log.info("Updated Resource From : " + oldScheduleInterview );
			ScheduleInterview updateScheduleInterview = scheduleinterviewRepository.save(scheduleInterview);
			log.info("To : " + updateScheduleInterview);
		}
		else
			throw new IntervieweeNotFoundException("Resource " + scheduleInterview.getId() + " not fond for updatation");
	}
	
	
}
