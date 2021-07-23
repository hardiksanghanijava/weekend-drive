package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.Id;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.response.ScheduleInterviewNameResponse;


public class ScheduleInterviewNameDto {
	
	@Id
	private int id;
	private String intervieweeName;
	private String interviewerName;
	private String positionsName;
	private String roundName;
	private Date time;
	private String status;
	
	public ScheduleInterviewNameDto() {}
	
	public ScheduleInterviewNameDto(int id, String intervieweeName, String interviewerName, String positionsName,
			String roundName, Date time, String status) {
		super();
		this.id = id;
		this.intervieweeName = intervieweeName;
		this.interviewerName = interviewerName;
		this.positionsName = positionsName;
		this.roundName = roundName;
		this.time = time;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getIntervieweeName() {
		return intervieweeName;
	}
	public void setIntervieweeName(String intervieweeName) {
		this.intervieweeName = intervieweeName;
	}
	public String getInterviewerName() {
		return interviewerName;
	}
	public void setInterviewerName(String interviewerName) {
		this.interviewerName = interviewerName;
	}
	public String getPositionsName() {
		return positionsName;
	}
	public void setPositionsName(String positionsName) {
		this.positionsName = positionsName;
	}
	public String getRoundName() {
		return roundName;
	}
	public void setRoundName(String roundName) {
		this.roundName = roundName;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
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
