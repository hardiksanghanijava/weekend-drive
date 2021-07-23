package com.weekend.drive.interview.service.impl;

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

import com.weekend.drive.interview.bean.ScheduleInterview;
import com.weekend.drive.interview.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.bean.ScheduleInterviewListDto;
import com.weekend.drive.interview.bean.ScheduleInterviewNameDto;
import com.weekend.drive.interview.exception.IntervieweeNotFoundException;
import com.weekend.drive.interview.repository.ScheduleInterviewDtoRepository;
import com.weekend.drive.interview.repository.ScheduleInterviewRepository;
import com.weekend.drive.interview.request.ScheduleInterviewCreateRequest;
import com.weekend.drive.interview.request.ScheduleInterviewUpdateRequest;
import com.weekend.drive.interview.response.ScheduleInterviewNameResponse;
import com.weekend.drive.interview.response.ScheduleInterviewResponse;
import com.weekend.drive.interview.service.ScheduleInterviewService;

@Service
public class ScheduleInterviewServiceImpl implements  ScheduleInterviewService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ScheduleInterviewRepository scheduleinterviewRepository;
	
	@Autowired
	private ScheduleInterviewDtoRepository scheduleInterviewDtoRepository;
	
	@Autowired
	private IntervieweeServiceImpl intervieweeServiceImpl;
	
	@Autowired
	private InterviewerServiceImpl interviewerServiceImpl;
	
	@Autowired
	private PositionServiceImpl positionsServiceImpl;
	
	@Autowired
	private RoundServiceImpl roundServiceImpl;
	
	@Autowired
	private EntityManager entityManager;
	
	//Retrieve all scheduled interview
	@Override
	public List<ScheduleInterviewResponse> getAllScheduleInterviewDto(){
		//Retrieving the original entity
		List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
		
		//Creating DTO List
		List<ScheduleInterviewDto> scheduleInterviewDto = new ArrayList<>();
		
		//Iterating entity to DTO
		scheduleInterview.stream().forEach(scheduleInterviews -> {
			scheduleInterviewDto.add(new ScheduleInterviewDto(scheduleInterviews.getId(), scheduleInterviews.getInterviewee().getId(),
					scheduleInterviews.getInterviewer().getId(), scheduleInterviews.getPositions().getId(),
					scheduleInterviews.getRound().getId(), scheduleInterviews.getTime(), scheduleInterviews.getStatus(),
					scheduleInterviews.isIsdeleted()));
		});
		
		//Creating Response list 
		List<ScheduleInterviewResponse> scheduleInterviewResponse = new ArrayList<>();
		
		//Iterating DTO list to response list 
		scheduleInterviewDto.stream().forEach(scheduleInterviews -> {
			try {
				scheduleInterviewResponse.add(ScheduleInterviewDto.toScheduleInterviewEntityResponse(scheduleInterviews));
			} catch (IllegalAccessException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
		
		logger.info("Retrieving All Records : " + scheduleInterviewResponse);
		
		//Returning response list
		return scheduleInterviewResponse;
	}

	//Retrieve all scheduled interview by Name
		@Override
		public List<ScheduleInterviewNameResponse> getAllScheduleInterviewNameDto(){
			//Retrieving the original entity
			List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
			
			//Creating DTO List
			List<ScheduleInterviewNameDto> scheduleInterviewNameDto = new ArrayList<>();
			
			//Iterating entity to DTO
			scheduleInterview.stream().forEach(scheduleInterviews -> {
				scheduleInterviewNameDto.add(new ScheduleInterviewNameDto(scheduleInterviews.getId(), scheduleInterviews.getInterviewee().getName(),
						scheduleInterviews.getInterviewer().getName(), scheduleInterviews.getPositions().getName(),
						scheduleInterviews.getRound().getName(), scheduleInterviews.getTime(), scheduleInterviews.getStatus()));
			});
			
			//Creating Response list 
			List<ScheduleInterviewNameResponse> scheduleInterviewNameResponse = new ArrayList<>();
			
			//Iterating DTO list to response list 
			scheduleInterviewNameDto.stream().forEach(scheduleInterviews -> {
				try {
					scheduleInterviewNameResponse.add(ScheduleInterviewNameDto.toScheduleInterviewNameResponse(scheduleInterviews));
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
			});
			
			logger.info("Retrieving All Records : " + scheduleInterviewNameResponse);
			
			//Returning response list
			return scheduleInterviewNameResponse;
		}
	
	//Retrieve Scheduled Interview List
	@Override
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
	@Override
	public Optional<ScheduleInterview> getScheduleInterviewById(int id){
		Optional<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findById(id);
		logger.info("Find record by id : " + scheduleInterview);
		if(scheduleInterview.isEmpty())
			throw new IntervieweeNotFoundException("Scheduled Interview " + id + " Not Foud");
		return scheduleInterview;
	}
	
	//Create Schedule Interview
	@Override
	public ScheduleInterviewDto createScheduleInterview(ScheduleInterviewCreateRequest scheduleInterviewCreateRequest) throws IllegalAccessException, InvocationTargetException {
		//checking if any id missing 
		intervieweeServiceImpl.getIntervieweeById(scheduleInterviewCreateRequest.getIntervieweeId());
		interviewerServiceImpl.getInterviewerById(scheduleInterviewCreateRequest.getInterviewerId());
		positionsServiceImpl.getPositionById(scheduleInterviewCreateRequest.getPositionsId());
		roundServiceImpl.getRoundById(scheduleInterviewCreateRequest.getRoundId());
		
		//Cheating Schedule Interview from request
		ScheduleInterviewDto scheduleInterview = scheduleinterviewRepository.save(ScheduleInterviewCreateRequest.toScheduleInterviewRequestEnttity(scheduleInterviewCreateRequest));
		logger.info("Created Resource : " + scheduleInterview);
		return scheduleInterview;
	}
	
	//Change Status to Reschedule 
	@Override
	public ScheduleInterview rescheduleStatus(int id) {
		Optional<ScheduleInterview> scheduleInterview = getScheduleInterviewById(id);
			ScheduleInterview saveScheduleInterview = scheduleInterview.get();
			saveScheduleInterview.setStatus("Reschedule");
		ScheduleInterview savedScheduleInterview = scheduleinterviewRepository.save(saveScheduleInterview);
			logger.info("Reschedule : " + saveScheduleInterview);
		return savedScheduleInterview;
	}
	
	//Change Status of Schedule Interview
	@Override
	public ScheduleInterview setScheduleInterviewStatus(int id, String status) {
		Optional<ScheduleInterview> scheduleInterview = getScheduleInterviewById(id);
		
			ScheduleInterview saveScheduleInterview = scheduleInterview.get();
			saveScheduleInterview.setStatus(status);
		ScheduleInterview savedScheduleInterview = 	scheduleinterviewRepository.save(saveScheduleInterview);
			logger.info("Reschedule : " + saveScheduleInterview);
		return savedScheduleInterview;
	}
	
	//Delete scheduled interview by id
	@Override
	public void deleteScheduleInterview(int id) {
			getScheduleInterviewById(id);
			logger.info("Deleted resource : " + id);
			scheduleInterviewDtoRepository.deleteById(id);
	}
	
	//Update existing scheduled interview
	@Override
	public ScheduleInterviewDto updateScheduleInterviewDto(ScheduleInterviewUpdateRequest scheduleInterviewUpdateRequest) throws IllegalAccessException, InvocationTargetException {
			//Checking if any id entering wrong
			getScheduleInterviewById(scheduleInterviewUpdateRequest.getId());
			intervieweeServiceImpl.getIntervieweeById(scheduleInterviewUpdateRequest.getIntervieweeId());
			interviewerServiceImpl.getInterviewerById(scheduleInterviewUpdateRequest.getInterviewerId());
			positionsServiceImpl.getPositionById(scheduleInterviewUpdateRequest.getPositionsId());
			roundServiceImpl.getRoundById(scheduleInterviewUpdateRequest.getRoundId());
			
			//Updating schedule interview
			ScheduleInterviewDto scheduleInterview = scheduleinterviewRepository.save(ScheduleInterviewUpdateRequest.toScheduleInterviewRequestEnttity(scheduleInterviewUpdateRequest));
			logger.info("Updated Resource : " + scheduleInterview);

			return scheduleInterview;
	}
	
	
	//Retrieve Scheduled Interview List
		@Override
		public List<ScheduleInterviewListDto> getScheduledListPagination(int page){
			int elementsPerPage = 3;
			
			String sqlQuery = "select scheduled_interview.id,interviewee.name as intervieweename,interviewer.name as interviewername,round.name as roundname,scheduled_interview.time,scheduled_interview.status from scheduled_interview inner join interviewee on scheduled_interview.interviewee_id=interviewee.id\r\n"
					+ " join interviewer on scheduled_interview.interviewer_id=interviewer.id inner join round on scheduled_interview.round_id=round.id";
			
			Query query = entityManager.createNativeQuery(sqlQuery);
			@SuppressWarnings("unchecked")
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
			
			@SuppressWarnings("unchecked")
			List<ScheduleInterviewListDto> finalList = query.setFirstResult(elementsPerPage * (page-1)).setMaxResults(elementsPerPage).getResultList();	
			
 			logger.info("Result list : " + finalList);
			return finalList;
		}



	
}
