package com.weekend.drive.interview.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.weekend.drive.interview.bean.ScheduleInterviewDto;

@Repository
public interface ScheduleInterviewDtoRepository extends JpaRepository<ScheduleInterviewDto,Integer>{


}
