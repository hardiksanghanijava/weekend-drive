package com.weekend.drive.interview.response;

import java.util.Date;

public class ScheduleInterviewResponse {

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

	@Override
	public String toString() {
		return "ScheduleInterviewResponse [intervieweeId=" + intervieweeId + ", interviewerId=" + interviewerId
				+ ", positionsId=" + positionsId + ", roundId=" + roundId + ", time=" + time + ", status=" + status
				+ ", isdeleted=" + isdeleted + "]";
	}
	
	
}
