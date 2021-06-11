package com.weekend.drive.interview.mini.project.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weekend.drive.interview.mini.project.bean.ScheduleInterview;
import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewListDto;
import com.weekend.drive.interview.mini.project.exception.IntervieweeNotFoundException;
import com.weekend.drive.interview.mini.project.repository.ScheduleInterviewDtoRepository;
import com.weekend.drive.interview.mini.project.repository.ScheduleInterviewRepository;

@Service
public class ScheduleInterviewService {
	
	Logger log = LoggerFactory.getLogger(this.getClass());

	private static final String TypedQuery = null;

	@Autowired
	private ScheduleInterviewRepository scheduleinterviewRepository;
	
	@Autowired
	private ScheduleInterviewDtoRepository scheduleInterviewDtoRepository;
	
	@Autowired
	private IntervieweeService intervieweeService;
	
	@Autowired
	private InterviewerService interviewerService;
	
	@Autowired
	private PositionService positionsService;
	
	@Autowired
	private RoundService roundService;
	
	@Autowired
	private EntityManager entityManager;
	

	public List<ScheduleInterview> getAllScheduleInterview(){
		List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
		log.info("All Retieved Records : " + scheduleInterview);
		return scheduleInterview;
	}
	
	//Retrieve all scheduled interview
	public List<ScheduleInterviewDto> getAllScheduleInterviewDto(){
		List<ScheduleInterviewDto> listDto = new ArrayList<>();
		List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
		for (ScheduleInterview scheduleInterview2 : scheduleInterview) {
			listDto.add(new ScheduleInterviewDto(scheduleInterview2.getId(), 
							scheduleInterview2.getInterviewee().getId(),
							scheduleInterview2.getInterviewer().getId(),
							scheduleInterview2.getPositions().getId(),
							scheduleInterview2.getRound().getId(),
							scheduleInterview2.getTime(),
							scheduleInterview2.getStatus(),
							scheduleInterview2.isIsdeleted()));
		}
		log.info("Retrieving All Records : " + listDto);
		
		return listDto;
	}
	
	//Retrieve Scheduled Interview List
	public List<ScheduleInterviewListDto> getScheduledList(){
		List<ScheduleInterviewListDto> scheduledInterviewlistDto = new ArrayList<>();
		List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
		for (ScheduleInterview list : scheduleInterview) {
			scheduledInterviewlistDto.add(new ScheduleInterviewListDto(list.getId(), list.getInterviewee().getName(),
					list.getInterviewer().getName(), list.getRound().getName(), list.getTime(), 
					list.getStatus()));
		}	
		return scheduledInterviewlistDto;
	}
	
	//Retrieve scheduled interview by id
	public Optional<ScheduleInterview> getScheduleInterviewById(int id){
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		log.info("Find record by id : " + scheduleInterview);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Scheduled Interview " + id + " Not Foud");
		return scheduleInterview;
	}
	
	//Create new scheduled interview
	public ScheduleInterviewDto createScheduleInterview(ScheduleInterviewDto scheduleInterviewdto) throws IllegalAccessException, InvocationTargetException {
		
		intervieweeService.getIntervieweeById(scheduleInterviewdto.getIntervieweeId());
		interviewerService.getInterviewerById(scheduleInterviewdto.getInterviewerId());
		positionsService.getPositionById(scheduleInterviewdto.getPositionsId());
		roundService.getRoundById(scheduleInterviewdto.getRoundId());
		
		ScheduleInterviewDto saveScheduleInterview = scheduleinterviewRepository.save(new ScheduleInterviewDto(
				scheduleInterviewdto.getId(), scheduleInterviewdto.getIntervieweeId(), scheduleInterviewdto.getInterviewerId(),
				scheduleInterviewdto.getPositionsId(), scheduleInterviewdto.getRoundId(), 
				scheduleInterviewdto.getTime(), scheduleInterviewdto.getStatus(), scheduleInterviewdto.isIsdeleted()));
		log.info("Created Resource : " + saveScheduleInterview);
		
		return saveScheduleInterview;
	}
	
	//Change Status to Reschedule 
	public void rescheduleStatus(int id) {
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Found");
		else {
			ScheduleInterview saveScheduleInterview = scheduleInterview.get();
			saveScheduleInterview.setStatus("Reschedule");
			scheduleinterviewRepository.save(saveScheduleInterview);
			log.info("Reschedule : " + saveScheduleInterview);
		}
	}
	
	//Change Status of Schedule Interview
	public void setScheduleInterviewStatus(int id, String status) {
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Resource " + id + " Not Found");
		else {
			ScheduleInterview saveScheduleInterview = scheduleInterview.get();
			saveScheduleInterview.setStatus(status);
			scheduleinterviewRepository.save(saveScheduleInterview);
			log.info("Reschedule : " + saveScheduleInterview);
		}
	}
	
	//Delete scheduled interview by id
	public void deleteScheduleInterview(int id) {
			getScheduleInterviewById(id);
			log.info("Deleted resource : " + id);
			scheduleInterviewDtoRepository.deleteById(id);
	}
	
	//Update existing scheduled interview
	public void updateScheduleInterviewDto(int id, ScheduleInterviewDto scheduleInterviewdto) {
		Optional<ScheduleInterview> oldScheduleInterview = scheduleinterviewRepository.findById(id);
		if(oldScheduleInterview.isPresent()) {
			log.info("Updated Resource From : " + oldScheduleInterview );
			ScheduleInterviewDto updateScheduleInterview = scheduleinterviewRepository.save(new ScheduleInterviewDto(
					scheduleInterviewdto.getId(), scheduleInterviewdto.getIntervieweeId(), scheduleInterviewdto.getIntervieweeId(),
					scheduleInterviewdto.getPositionsId(), scheduleInterviewdto.getRoundId(), 
					scheduleInterviewdto.getTime(), scheduleInterviewdto.getStatus(), scheduleInterviewdto.isIsdeleted()));
			log.info("To : " + updateScheduleInterview);
		}
		else
			throw new IntervieweeNotFoundException("Resource " + scheduleInterviewdto.getId() + " not fond for updatation");
	}
	
	
	//Retrieve Scheduled Interview List
		public List<ScheduleInterviewListDto> getScheduledListPagination(int page){
			int elementsPerPage = 3;
			
			String sqlQuery = "select scheduled_interview.id,interviewee.name as intervieweename,interviewer.name as interviewername,round.name as roundname,scheduled_interview.time,scheduled_interview.status from scheduled_interview inner join interviewee on scheduled_interview.interviewee_id=interviewee.id\r\n"
					+ " join interviewer on scheduled_interview.interviewer_id=interviewer.id inner join round on scheduled_interview.round_id=round.id";
			
			Query query = entityManager.createNativeQuery(sqlQuery);
			List<ScheduleInterviewListDto> resultList = query.getResultList();
	
			int sizeOfList = resultList.size();
			int maxPage = sizeOfList/elementsPerPage;
			
			if(sizeOfList%elementsPerPage==0) {
				if(page>maxPage)
					throw new IntervieweeNotFoundException("Page limit exceeded");
			}
			else{
			    if(page>maxPage+1)
			        throw new IntervieweeNotFoundException("Page limit exceeded");
			}
			
			List<ScheduleInterviewListDto> finalList = query.setFirstResult(elementsPerPage * (page-1)).setMaxResults(elementsPerPage).getResultList();	
			
 			log.info("Result list : " + finalList);
			return finalList;
		}
	
	
	
}
