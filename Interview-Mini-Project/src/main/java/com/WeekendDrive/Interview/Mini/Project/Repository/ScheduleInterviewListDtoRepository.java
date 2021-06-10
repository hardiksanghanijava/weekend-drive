package com.WeekendDrive.Interview.Mini.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterviewDto;
import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterviewListDto;

@EnableJpaRepositories
public interface ScheduleInterviewListDtoRepository extends JpaRepository<ScheduleInterviewListDto, Integer>{

	ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);


}
