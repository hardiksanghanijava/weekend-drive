package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ScheduleInterview {
	

	@Id
	private int id;
	private Date time;
	private String status;
	
	@ManyToOne
	Interviewee interviewee;
	
	@ManyToOne
	Interviewer interviewer;
	
	@ManyToOne
	Positions positions;
	
	@ManyToOne
	Round round;
	
	protected ScheduleInterview() {}
	
	public ScheduleInterview(int id, Date time, String status) {
		super();
		this.id = id;
		this.time = time;
		this.status = status;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	
	public Interviewee getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(Interviewee interviewee) {
		this.interviewee = interviewee;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(Interviewer interviewer) {
		this.interviewer = interviewer;
	}

	public Positions getPositions() {
		return positions;
	}

	public void setPositions(Positions positions) {
		this.positions = positions;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	@Override
	public String toString() {
		return "ScheduleInterview [id=" + id + ", time=" + time + ", status=" + status + "]";
	}
	
}
