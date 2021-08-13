package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.response.ScheduleInterviewNameResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleInterviewNameDto {
	
	@Id
	private int id;
	private String intervieweeName;
	private String interviewerName;
	private String positionsName;
	private String roundName;
	private Date time;
	private String status;
	
	
	public static ScheduleInterviewNameResponse toScheduleInterviewNameResponse(ScheduleInterviewNameDto scheduleInterviewNameDto) throws IllegalAccessException, InvocationTargetException {
		ScheduleInterviewNameResponse scheduleInterviewNameResponse = new ScheduleInterviewNameResponse();
		BeanUtils.copyProperties(scheduleInterviewNameResponse, scheduleInterviewNameDto);
		return scheduleInterviewNameResponse;	
	}
	
	@Override
	public String toString() {
		return "ScheduleInterviewNameDto [id=" + id + ", intervieweeName=" + intervieweeName + ", interviewerName="
				+ interviewerName + ", positionsName=" + positionsName + ", roundName=" + roundName + ", time=" + time
				+ ", status=" + status + "]";
	}
	
	

}
