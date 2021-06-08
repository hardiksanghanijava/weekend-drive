package com.WeekendDrive.Interview.Mini.Project.Bean;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="interviewer")
public class Interviewer {
	
	@Id
	private int id;
	@Size(min=2, message="Name should be more than 2 letters")
	private String name;
	
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

	@Override
	public String toString() {
		return "Interviewer [id=" + id + ", name=" + name + "]";
	}
	

}
