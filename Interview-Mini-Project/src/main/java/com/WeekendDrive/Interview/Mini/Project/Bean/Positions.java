package com.WeekendDrive.Interview.Mini.Project.Bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
public class Positions 
{
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private String description;
	
	@OneToMany(mappedBy="positions")
	private List<ScheduleInterview> scheduleInterview = new ArrayList<>();
	
	public Positions() {}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Positions(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

		
}
