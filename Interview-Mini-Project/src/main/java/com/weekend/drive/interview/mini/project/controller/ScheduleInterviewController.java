package  com.weekend.drive.interview.mini.project.controller;



import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekend.drive.interview.mini.project.bean.ScheduleInterview;
import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewListDto;
import com.weekend.drive.interview.mini.project.repository.ScheduleInterviewListDtoRepository;
import com.weekend.drive.interview.mini.project.repository.ScheduleInterviewRepository;
import com.weekend.drive.interview.mini.project.service.ScheduleInterviewService;



@RestController
@RequestMapping("/api/interview")
public class ScheduleInterviewController {

	@Autowired
	private ScheduleInterviewService scheduleInterviewService;
	
	@Autowired
	private ScheduleInterviewListDtoRepository scheduleInterviewListDtoRepository;
	
	@Autowired
	ScheduleInterviewRepository scheduleInterviewRepository;
	
	//Find All Data
	@GetMapping("/schedule")
	public List<ScheduleInterviewDto> getAllScheduleInterview(){
		return scheduleInterviewService.getAllScheduleInterviewDto();
	}
	
	//Find Data By Id
	@GetMapping("/schedule/{id}")
	public Optional<ScheduleInterview> getScheduleInterviewById(@PathVariable int id){
		return scheduleInterviewService.getScheduleInterviewById(id);
	}
		
	//Get Scheduled List
	@GetMapping("/schedule/list")
	public List<ScheduleInterviewListDto> getScheduledList(){
		return scheduleInterviewService.getScheduledList();
	}
	
	//Get Scheduled List In Pagination
	@GetMapping("/schedule/list/{page}")
	public List<ScheduleInterviewListDto> getScheduledListPagination(@PathVariable int page){
		return scheduleInterviewService.getScheduledListPagination(page);
	}
		
	//Create Resource
	@PostMapping("/add")
	public ResponseEntity<Object> createScheduleInterview(@Validated @RequestBody ScheduleInterviewDto scheduleInterview) throws IllegalAccessException, InvocationTargetException {
		scheduleInterviewService.createScheduleInterview(scheduleInterview);
		return new ResponseEntity<Object>("Interview Scheduled Successfully", HttpStatus.CREATED);
	}
	
	//Reschedule Status
	@PutMapping("/reschedule/{id}")
	public ResponseEntity<Object> rescheduleStatus(@PathVariable int id){
		scheduleInterviewService.rescheduleStatus(id);
		return new ResponseEntity<Object>("Interview Rescheduled Successfully", HttpStatus.ACCEPTED);
	}
	
	//Change Status
	@PutMapping("/{id}/status")
	public ResponseEntity<Object> setScheduleInterviewStatus(@PathVariable int id, @RequestBody String status){
		scheduleInterviewService.setScheduleInterviewStatus(id, status);
		return new ResponseEntity<Object>("Status Updated to " + status + " Successfully", HttpStatus.ACCEPTED);
	}	
	
	//Delete Resource By Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteScheduleInterview(@PathVariable int id) {
		scheduleInterviewService.deleteScheduleInterview(id);
		return new ResponseEntity<Object>("Interview Deleted Successfully", HttpStatus.ACCEPTED);
	}
	
	//Update Resource
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateScheduleInterview(@Validated @PathVariable int id, @RequestBody ScheduleInterviewDto scheduleInterviewdto) {
		scheduleInterviewService.updateScheduleInterviewDto(id, scheduleInterviewdto);
		return new ResponseEntity<Object>("Interview Updated Successfully", HttpStatus.ACCEPTED);
	}
	
}
