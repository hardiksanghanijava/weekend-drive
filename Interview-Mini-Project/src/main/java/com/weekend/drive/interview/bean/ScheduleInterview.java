package com.weekend.drive.interview.bean;

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

import lombok.Data;

@Entity
@SQLDelete(sql="update scheduled_interview set isdeleted=true where id = ?")
@Where(clause="isdeleted = false")
@Table(name="scheduled_interview")
@Data
public class ScheduleInterview {
	

	@Id
	private int id;
	private Date time;
	private String status;
	private boolean isdeleted;
	
	
	@ManyToOne(fetch=FetchType.EAGER, targetEntity = Interviewee.class, cascade=CascadeType.ALL, optional = false)
	@JoinColumn(name="interviewee_id", referencedColumnName="id")
	private Interviewee interviewee;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="interviewer_id", referencedColumnName="id")
	private Interviewer interviewer;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="positions_id", referencedColumnName="id")
	private Positions positions;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="round_id", referencedColumnName="id")
	private Round round;
	
//	@Cacheable
//	public String getStatus() {
//		try {
//			Thread.sleep(400);
//		} catch (InterruptedException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		return this.status;
//	}


	@Override
	public String toString() {
		return "ScheduleInterview [id=" + id + ", time=" + time + ", status=" + status + "]";
	}
	
}
