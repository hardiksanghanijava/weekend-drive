package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@SQLDelete(sql="update scheduled_interview set isdeleted=true where id = ?")
@Where(clause="isdeleted = false")
@Table(name="scheduled_interview")
public class ScheduleInterview {
	

	@Id
	private int id;
	private Date time;
	private String status;
	private boolean isdeleted;
	
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity = Interviewee.class, cascade=CascadeType.ALL, optional = false)
	@JoinColumn(name="interviewee_id", referencedColumnName="id")
	//@JsonIgnore
	private Interviewee interviewee;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="interviewer_id", referencedColumnName="id")
	private Interviewer interviewer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="positions_id", referencedColumnName="id")
	private Positions positions;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="round_id", referencedColumnName="id")
	private Round round;
	
	
	public Interviewee getInterviewee() {
		 return interviewee;
	}

	public Interviewer getInterviewer() {
		return interviewer;
	}

	public Positions getPositions() {
		return positions;
	}

	public Round getRound() {
		return round;
	}

	public boolean isIsdeleted() {
		return isdeleted;
	}

	public void setIsdeleted(boolean isdeleted) {
		this.isdeleted = isdeleted;
	}

	public ScheduleInterview() {}
	
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

	
	

	@Override
	public String toString() {
		return "ScheduleInterview [id=" + id + ", time=" + time + ", status=" + status + "]";
	}
	
}
