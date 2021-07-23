package com.weekend.drive.interview.response;

import java.util.Date;


public class ScheduleInterviewNameResponse {
	
	private int id;
	private String intervieweeName;
	private String interviewerName;
	private String positionsName;
	private String roundName;
	private Date time;
	private String status;
	private boolean isdeleted;
	
	
	public ScheduleInterviewNameResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ScheduleInterviewNameResponse(int id, String intervieweeName, String interviewerName, String positionsName,
			String roundName, Date time, String status, boolean isdeleted) {
		super();
		this.id = id;
		this.intervieweeName = intervieweeName;
		this.interviewerName = interviewerName;
		this.positionsName = positionsName;
		this.roundName = roundName;
		this.time = time;
		this.status = status;
		this.isdeleted = isdeleted;
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
	public boolean isIsdeleted() {
		return isdeleted;
	}
	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}
	
	@Override
	public String toString() {
		return "ScheduleInterveiewNameResponse [id=" + id + ", intervieweeName=" + intervieweeName
				+ ", interviewerName=" + interviewerName + ", positionsName=" + positionsName + ", roundName="
				+ roundName + ", time=" + time + ", status=" + status + ", isdeleted=" + isdeleted + "]";
	}
	
	

}
