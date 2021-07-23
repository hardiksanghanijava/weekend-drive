package com.weekend.drive.interview.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.bean.Interviewee;

@Repository
public interface IntervieweeRepository extends JpaRepository<Interviewee,Integer> {
	public List<Interviewee> findByName(String name);
}

