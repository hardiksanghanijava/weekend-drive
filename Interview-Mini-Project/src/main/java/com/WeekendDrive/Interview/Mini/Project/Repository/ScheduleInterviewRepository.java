package com.WeekendDrive.Interview.Mini.Project.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.WeekendDrive.Interview.Mini.Project.Bean.ScheduleInterview;

@Repository
public interface ScheduleInterviewRepository extends JpaRepository<ScheduleInterview,Integer>{

}
