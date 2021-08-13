package com.weekend.drive.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.bean.ScheduleInterview;
import com.weekend.drive.interview.bean.ScheduleInterviewDto;

@Repository
public interface ScheduleInterviewRepository extends JpaRepository<ScheduleInterview,Integer>{

	ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);

}
