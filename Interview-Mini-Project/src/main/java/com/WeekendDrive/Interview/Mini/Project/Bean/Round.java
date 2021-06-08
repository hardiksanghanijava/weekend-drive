package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
public class Round {

	@Id
	//@GeneratedValue
	private int id;

	@Size(min=3, message="name should be more than 2 letters")
	private String name;

	private int sequence;
	
	@OneToMany(mappedBy="round")
	List<ScheduleInterview> scheduleInterview = new ArrayList<>();

	protected Round() {}
	
	
	
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
	
	


}
