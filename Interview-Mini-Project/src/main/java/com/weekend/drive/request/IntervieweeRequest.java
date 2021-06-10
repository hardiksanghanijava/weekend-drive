package com.weekend.drive.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.WeekendDrive.Interview.Mini.Project.Bean.Interviewee;

public class IntervieweeRequest {

	private String name;
	private String skills;
	private String experience;
	private String qualification;
	
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
	public static Interviewee toIntervieweeRequestEnttity(IntervieweeRequest intervieweeRequest) throws IllegalAccessException, InvocationTargetException {
		Interviewee interviewee = new Interviewee();
		BeanUtils.copyProperties(interviewee, intervieweeRequest);
		return interviewee;
	}
	
	
}
