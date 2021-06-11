package com.weekend.drive.interview.bean;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weekend.drive.interview.response.InterviewerResponse;

@Entity
@Table(name="interviewer")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
public class Interviewer {
	
	@Id
	private int id;
	@Size(min=2, message="Name should be more than 2 letters")
	private String name;
	
	@OneToMany(mappedBy="interviewer")
	private List<ScheduleInterview> scheduleInterview = new ArrayList<>();
	
	public Interviewer(){}
	

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
	public static InterviewerResponse toInterviewerEntityResponse(Interviewer interviewer) throws IllegalAccessException, InvocationTargetException {
		InterviewerResponse interviewerResponse = new InterviewerResponse();
		BeanUtils.copyProperties(interviewerResponse, interviewer);
		return interviewerResponse;	
	}
	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", name=" + name + "]";
	}
	

}
