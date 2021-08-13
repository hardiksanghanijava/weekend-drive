package com.weekend.drive.interview.response;

public class IntervieweeResponse {

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

	@Override
	public String toString() {
		return "IntervieweeResponse [id=" + id + ", name=" + name + ", skills=" + skills + ", experience=" + experience
				+ ", qualification=" + qualification + "]";
	}
	
	
}
