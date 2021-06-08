package com.WeekendDrive.Interview.Mini.Project.Bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="interviewee")
public class Interviewee {
	
	@Id
	@Column(name="id")
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
	
	public Interviewee(){}
	
	public Interviewee(int id, String name, String skills, String experience, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.experience = experience;
		this.qualification = qualification;
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
		return "Interviewee [id=" + id + ", name=" + name + ", skills=" + skills + ", experience=" + experience
				+ ", qualification=" + qualification + "]";
	}
	

}
