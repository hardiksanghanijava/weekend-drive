package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ScheduleInterviewListDto {
	
	@Id
	private int id;
	private String interviewee_name;
	private String interviewer_name;
	private String round_name;
	private Date time;
	private String status;
	
	public ScheduleInterviewListDto() {}

	
	public ScheduleInterviewListDto(int id, String interviewee_name, String interviewer_name, String round_name,
			Date time, String status) {
		super();
		this.id = id;
		this.interviewee_name = interviewee_name;
		this.interviewer_name = interviewer_name;
		this.round_name = round_name;
		this.time = time;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getInterviewee_name() {
		return interviewee_name;
	}


	public void setInterviewee_name(String interviewee_name) {
		this.interviewee_name = interviewee_name;
	}


	public String getInterviewer_name() {
		return interviewer_name;
	}


	public void setInterviewer_name(String interviewer_name) {
		this.interviewer_name = interviewer_name;
	}


	public String getRound_name() {
		return round_name;
	}


	public void setRound_name(String round_name) {
		this.round_name = round_name;
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


	@Override
	public String toString() {
		return "ScheduleInterviewListDto [id=" + id + ", interviewee_name=" + interviewee_name + ", interviewer_name="
				+ interviewer_name + ", round_name=" + round_name + ", time=" + time + ", status=" + status + "]";
	}
	
}
