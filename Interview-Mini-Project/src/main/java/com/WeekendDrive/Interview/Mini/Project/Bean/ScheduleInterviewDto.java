package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="scheduled_interview")
public class ScheduleInterviewDto {
	
	@Id
	private int id;
	
	@JsonProperty("interviewee_id")
	@Column(name="interviewee_id")
	private int intervieweeId;
	
	@JsonProperty("interviewer_id")
	@Column(name="interviewer_id")
	private int interviewerId;
	
	@JsonProperty("positions_id")
	@Column(name="positions_id")
	private int positionsId;
	
	@JsonProperty("round_id")
	@Column(name="round_id")
	private int roundId;
	
	private Date time;
	private String status;
	private boolean isdeleted;
	
	public ScheduleInterviewDto() {}

	public ScheduleInterviewDto(int id, int intervieweeId, int interviewerId, int positionsId, int roundId, Date time,
			String status, boolean isdeleted) {
		super();
		this.id = id;
		this.intervieweeId = intervieweeId;
		this.interviewerId = interviewerId;
		this.positionsId = positionsId;
		this.roundId = roundId;
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
		return "ScheduleInterviewDto [id=" + id + ", intervieweeId=" + intervieweeId + ", interviewerId="
				+ interviewerId + ", positionsId=" + positionsId + ", roundId=" + roundId + ", time=" + time
				+ ", status=" + status + ", isdeleted=" + isdeleted + "]";
	}
	
}
