package com.weekend.drive.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.weekend.drive.interview.bean.ScheduleInterviewDto;
import com.weekend.drive.interview.bean.ScheduleInterviewListDto;

@EnableJpaRepositories
public interface ScheduleInterviewListDtoRepository extends JpaRepository<ScheduleInterviewListDto, Integer>{

	ScheduleInterviewDto save(ScheduleInterviewDto scheduleInterviewDto);


}
