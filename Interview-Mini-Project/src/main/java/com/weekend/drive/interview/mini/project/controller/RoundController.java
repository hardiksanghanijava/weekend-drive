package  com.weekend.drive.interview.mini.project.controller;

import java.util.List;
import java.util.Optional;

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

import com.weekend.drive.interview.mini.project.bean.Round;
import com.weekend.drive.interview.mini.project.service.RoundService;
import com.weekend.drive.response.ApiResponse;

import ccom.weekend.drive.interview.mini.project.request.RoundRequest;

@RestController
@RequestMapping("/api/round")
public class RoundController {
	
	@Autowired
	private RoundService roundService;
	
	//method to retrieve all the rounds	
	@GetMapping("/list")
	public List<Round> getAllRounds(){
		return roundService.getAllRounds();
	}
	
	//method to retrieve the rounds by specific id	
	@GetMapping("/view/{id}")
	public Optional<Round> getRoundById(@PathVariable int id){
		return roundService.getRoundById(id);
	}
	
	//method to delete the rounds by specific id	
	@DeleteMapping("/delete/{id}")
	public  ResponseEntity<?> deleteRound(@PathVariable int id){
		roundService.deleteRound(id);
		return new ResponseEntity<>(new ApiResponse(id,"The Round was  successfully deleted at id:") ,HttpStatus.ACCEPTED);
	}
	
	//method to update the rounds by specific id
    @PutMapping("/update/{id}")
	public  ResponseEntity<?> updateRound(@Valid @PathVariable int id, @RequestBody RoundRequest roundRequest){
		roundService.updateRound(id, roundRequest);
		return new ResponseEntity<>(new ApiResponse(id,"The Round was updated successfully at id:") , HttpStatus.ACCEPTED);
		
	}
	
	
	
}
