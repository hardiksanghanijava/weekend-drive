package com.weekend.drive.interview.bean;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weekend.drive.interview.response.IntervieweeResponse;

import lombok.Data;

@Entity
@Table(name="interviewee")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
@Data
public class Interviewee {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	@Size(min=2, message="Name should be more than 2 letters")
	private String name;
	@Column(name="skills")
	private String skills;
	@Column(name="experience")
	private String experience;
	@Column(name="qualification")
	private String qualification;
	
	@OneToMany(mappedBy="interviewee")
	private List<ScheduleInterview> scheduleInterview = new ArrayList<>();
	

	public static IntervieweeResponse toIntervieweeEntityResponse(Interviewee interviewee) throws IllegalAccessException, InvocationTargetException {
		IntervieweeResponse intervieweeResponse = new IntervieweeResponse();
		BeanUtils.copyProperties(intervieweeResponse, interviewee);
		return intervieweeResponse;	
	}

	@Override
	public String toString() {
		return "Interviewee [id=" + id + ", name=" + name + ", skills=" + skills + ", experience=" + experience
				+ ", qualification=" + qualification + "]";
	}



}
