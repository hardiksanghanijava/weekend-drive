package  com.weekend.drive.interview.controller;

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

import com.weekend.drive.interview.request.RoundUpdateRequest;
import com.weekend.drive.interview.response.ApiResponse;
import com.weekend.drive.interview.response.RoundResponse;
import com.weekend.drive.interview.service.impl.RoundServiceImpl;



@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	@Autowired
	private RoundServiceImpl roundService;
	
	//method to retrieve all the rounds	
	@GetMapping("/list")
	public ResponseEntity<?> getAllRounds(){
		return new ResponseEntity<>(new ApiResponse<>(roundService.getAllRounds(),"All the Rounds :") ,HttpStatus.ACCEPTED);
	}
	
	//method to retrieve the rounds by specific id	
	@GetMapping("/view/{id}")
	public ResponseEntity<?> getRoundById(@PathVariable int id) throws IllegalAccessException, InvocationTargetException{
		return new ResponseEntity<>(new ApiResponse<>(roundService.getRoundById(id),"The Round present at this id :") ,HttpStatus.ACCEPTED);
	}
	
	//method to delete the rounds by specific id	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteRound(@PathVariable int id) throws IllegalAccessException, InvocationTargetException{
		roundService.deleteRound(id);
		return new ResponseEntity<>(new ApiResponse<>(id,"The Round was  successfully deleted at id:") ,HttpStatus.ACCEPTED);
	}
	
	//method to update the rounds by specific id
    @PutMapping("/update/{id}")
	public  ResponseEntity<?> updateRound(@Valid @PathVariable int id, @RequestBody RoundUpdateRequest roundRequest) throws IllegalAccessException, InvocationTargetException{
		roundService.updateRound(id, roundRequest);
		return new ResponseEntity<>(new ApiResponse<>(id,"The Round was updated successfully at id:") , HttpStatus.ACCEPTED);
		
	}
	
	
	
}
