package  com.weekend.drive.interview.mini.project.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.weekend.drive.interview.mini.project.request.RoundUpdateRequest;
import com.weekend.drive.interview.mini.project.response.RoundResponse;
import com.weekend.drive.interview.mini.project.service.RoundService;
import com.weekend.drive.response.ApiResponse;



@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	@Autowired
	private RoundService roundService;
	
	//method to retrieve all the rounds	
	@GetMapping("/list")
	public List<RoundResponse> getAllRounds(){
		return roundService.getAllRounds();
	}
	
	//method to retrieve the rounds by specific id	
	@GetMapping("/view/{id}")
	public RoundResponse getRoundById(@PathVariable int id) throws IllegalAccessException, InvocationTargetException{
		return roundService.getRoundById(id);
	}
	
	//method to delete the rounds by specific id	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteRound(@PathVariable int id) throws IllegalAccessException, InvocationTargetException{
		roundService.deleteRound(id);
		return new ResponseEntity<>(new ApiResponse(id,"The Round was  successfully deleted at id:") ,HttpStatus.ACCEPTED);
	}
	
	//method to update the rounds by specific id
    @PutMapping("/update/{id}")
	public  ResponseEntity<?> updateRound(@Valid @PathVariable int id, @RequestBody RoundUpdateRequest roundRequest) throws IllegalAccessException, InvocationTargetException{
		roundService.updateRound(id, roundRequest);
		return new ResponseEntity<>(new ApiResponse(id,"The Round was updated successfully at id:") , HttpStatus.ACCEPTED);
		
	}
	
	
	
}
