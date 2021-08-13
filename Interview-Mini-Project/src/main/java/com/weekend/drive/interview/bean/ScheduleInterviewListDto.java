package com.weekend.drive.interview.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleInterviewListDto {
	
	@Id
	private int id;
	private String interviewee_name;
	private String interviewer_name;
	private String round_name;
	private Date time;
	private String status;
	
	

	@Override
	public String toString() {
		return "ScheduleInterviewListDto [id=" + id + ", interviewee_name=" + interviewee_name + ", interviewer_name="
				+ interviewer_name + ", round_name=" + round_name + ", time=" + time + ", status=" + status + "]";
	}
	
}
