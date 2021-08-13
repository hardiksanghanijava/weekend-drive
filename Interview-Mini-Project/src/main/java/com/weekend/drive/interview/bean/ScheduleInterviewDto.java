package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.weekend.drive.interview.response.ScheduleInterviewResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="scheduled_interview")
@Getter
@Setter
@NoArgsConstructor
public class ScheduleInterviewDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	

	public static ScheduleInterviewResponse toScheduleInterviewEntityResponse(ScheduleInterviewDto scheduleInterviewDto) throws IllegalAccessException, InvocationTargetException {
		ScheduleInterviewResponse scheduleInterviewResponse = new ScheduleInterviewResponse();
		BeanUtils.copyProperties(scheduleInterviewResponse, scheduleInterviewDto);
		return scheduleInterviewResponse;	
	}

	@Override
	public String toString() {
		return "ScheduleInterviewDto [id=" + id + ", intervieweeId=" + intervieweeId + ", interviewerId="
				+ interviewerId + ", positionsId=" + positionsId + ", roundId=" + roundId + ", time=" + time
				+ ", status=" + status + ", isdeleted=" + isdeleted + "]";
	}

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
	
}
