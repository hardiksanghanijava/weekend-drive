package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="scheduled_interview")
public class ScheduleInterviewDto {
	
	@Id
	private int id;
	private int interviewee_id;
	private int interviewer_id;
	private int positions_id;
	private int round_id;
	private Date time;
	private String status;
	private boolean isdeleted;
	
	public ScheduleInterviewDto() {}
	
	public ScheduleInterviewDto(int id, int interviewee_id, int interviewer_id, int positions_id, int round_id,
			Date time, String status, boolean isdeleted) {
		super();
		this.id = id;
		this.interviewee_id = interviewee_id;
		this.interviewer_id = interviewer_id;
		this.positions_id = positions_id;
		this.round_id = round_id;
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
	public int getInterviewee_id() {
		return interviewee_id;
	}
	public void setInterviewee_id(int interviewee_id) {
		this.interviewee_id = interviewee_id;
	}
	public int getInterviewer_id() {
		return interviewer_id;
	}
	public void setInterviewer_id(int interviewer_id) {
		this.interviewer_id = interviewer_id;
	}
	public int getPositions_id() {
		return positions_id;
	}
	public void setPositions_id(int positions_id) {
		this.positions_id = positions_id;
	}
	public int getRound_id() {
		return round_id;
	}
	public void setRound_id(int round_id) {
		this.round_id = round_id;
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
		return "ScheduleInterviewDto [id=" + id + ", interviewee_id=" + interviewee_id + ", interviewer_id="
				+ interviewer_id + ", positions_id=" + positions_id + ", round_id=" + round_id + ", time=" + time
				+ ", status=" + status + ", isdeleted=" + isdeleted + "]";
	}
	
	
	
}
