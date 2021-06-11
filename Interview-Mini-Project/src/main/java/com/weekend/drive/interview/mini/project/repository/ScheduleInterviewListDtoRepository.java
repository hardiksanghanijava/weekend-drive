package com.weekend.drive.interview.mini.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.mini.project.bean.ScheduleInterviewListDto;

@EnableJpaRepositories
public interface ScheduleInterviewListDtoRepository extends JpaRepository<ScheduleInterviewListDto, Integer>{

	ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);


}
