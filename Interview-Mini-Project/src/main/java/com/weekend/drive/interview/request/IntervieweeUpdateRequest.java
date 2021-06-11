package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Interviewee;

public class IntervieweeUpdateRequest {
	
	private int id;
	private String name;
	private String skills;
	private String experience;
	private String qualification;

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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public static Interviewee toIntervieweeRequestEnttity(IntervieweeUpdateRequest intervieweeUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewee interviewee = new Interviewee();
		BeanUtils.copyProperties(interviewee, intervieweeUpdateRequest);
		return interviewee;
	}
	
	
}
