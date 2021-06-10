package com.WeekendDrive.Interview.Mini.Project.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;
import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterviewDto;
import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterviewListDto;
import com.WeekendDrive.Interview.Mini.Project.Exception.IntervieweeNotFoundException;
import com.WeekendDrive.Interview.Mini.Project.Repository.ScheduleInterviewDtoRepository;
import com.WeekendDrive.Interview.Mini.Project.Repository.ScheduleInterviewRepository;

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
	public ScheduleInterviewDto createScheduleInterview(ScheduleInterviewDto scheduleInterviewdto) {
		
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
	
	
	@Autowired
	EntityManager em;
	
//	//Retrieve Scheduled Interview List
//		public List<ScheduleInterviewListDto> getScheduledListPagination(){
//			List<ScheduleInterviewListDto> listDto = new ArrayList<>();
//			List<ScheduleInterview> scheduleInterview =  scheduleinterviewRepository.findAll();
//			for (ScheduleInterview list : scheduleInterview) {
//				listDto.add(new ScheduleInterviewListDto(list.getId(), list.getInterviewee().getName(),
//						list.getInterviewer().getName(), list.getRound().getName(), list.getTime(), 
//						list.getStatus()));
//			}	
////			
////			Query query = em.createNativeQuery("select si.id,ie.name,iw.name,r.name,si.time,si.status from scheduled_interview as si join interviewee as ie on si.interviewee_id=ie.id\r\n"
////					+ " join interviewer as iw on si.interviewer_id=iw.id join round as r on si.round_id=r.id", ScheduleInterview.class);
////			
//			javax.persistence.TypedQuery<Object[]> query = em.createQuery("select si.id,ie.name,iw.name,r.name,si.time,si.status from ScheduleInterview si join Interviewee ie on si.interviewee_id=ie.id join Interviewer iw on si.interviewer_id=iw.id join Round r on si.round_id=r.id", Object[].class);
// 			List resultList = query.getResultList();
// 			
// 			log.info("Result list : " + resultList);
// 			
//			return listDto;
//		}
//	
	
	
}
