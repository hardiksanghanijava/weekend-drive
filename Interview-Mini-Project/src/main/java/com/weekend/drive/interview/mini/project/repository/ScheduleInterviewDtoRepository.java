package com.weekend.drive.interview.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewDto;

@Repository
public interface ScheduleInterviewDtoRepository extends JpaRepository<ScheduleInterviewDto,Integer>{

	//ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);

}
