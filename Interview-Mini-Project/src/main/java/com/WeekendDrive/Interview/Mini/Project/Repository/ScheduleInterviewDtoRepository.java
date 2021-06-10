package com.WeekendDrive.Interview.Mini.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterviewDto;

@Repository
public interface ScheduleInterviewDtoRepository extends JpaRepository<ScheduleInterviewDto,Integer>{

	//ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);

}
