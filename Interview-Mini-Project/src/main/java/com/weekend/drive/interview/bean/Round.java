package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.weekend.drive.interview.response.RoundResponse;



@Entity
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
public class Round {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Size(min=3, message="name should be more than 2 letters")
	private String name;

	private int sequence;
	
	@OneToMany(mappedBy="round")
	List<ScheduleInterview> scheduleInterview = new ArrayList<>();

	public Round() {}
	
	
	
	@Override
	public String toString() {
		return "Round [id=" + id + ", name=" + name + ", sequence=" + sequence + "]";
	}
	


	public Round(int id, String name, int sequence) {
		super();
		this.id = id;
		this.name = name;
		this.sequence = sequence;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}



	public List<ScheduleInterview> getScheduleInterview() {
		return scheduleInterview;
	}



	public void addScheduleInterview(ScheduleInterview scheduleInterview) {
		this.scheduleInterview .add(scheduleInterview);
	}
	
	public void removeScheduleInterview(ScheduleInterview scheduleInterview) {
		this.scheduleInterview .remove(scheduleInterview);
	}
	
	public static RoundResponse toRoundEntityResponse(Round round) throws IllegalAccessException, InvocationTargetException {
		RoundResponse roundResponse = new RoundResponse();
		BeanUtils.copyProperties(roundResponse, round);
		return roundResponse;


}
}