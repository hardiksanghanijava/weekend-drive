package com.weekend.drive.interview.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.bean.Interviewer;

@Repository
public interface InterviewerRepository extends JpaRepository<Interviewer,Integer> {	
	
}

