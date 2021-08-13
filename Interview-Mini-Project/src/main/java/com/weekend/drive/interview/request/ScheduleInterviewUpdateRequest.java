package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.ScheduleInterviewDto;

public class ScheduleInterviewUpdateRequest {

	private int id;
	private int intervieweeId;
	private int interviewerId;
	private int positionsId;
	private int roundId;
	private Date time;
	private String status;
	private boolean isdeleted;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIntervieweeId() {
		return intervieweeId;
	}

	public void setIntervieweeId(int intervieweeId) {
		this.intervieweeId = intervieweeId;
	}

	public int getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(int interviewerId) {
		this.interviewerId = interviewerId;
	}

	public int getPositionsId() {
		return positionsId;
	}

	public void setPositionsId(int positionsId) {
		this.positionsId = positionsId;
	}

	public int getRoundId() {
		return roundId;
	}

	public void setRoundId(int roundId) {
		this.roundId = roundId;
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

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public static ScheduleInterviewDto toScheduleInterviewRequestEnttity(ScheduleInterviewUpdateRequest scheduleInterviewUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		ScheduleInterviewDto scheduleInterviewDto = new ScheduleInterviewDto();
		BeanUtils.copyProperties(scheduleInterviewDto, scheduleInterviewUpdateRequest);
		return scheduleInterviewDto;
	}
	
	
}
