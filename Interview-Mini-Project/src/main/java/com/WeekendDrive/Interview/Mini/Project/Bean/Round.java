package com.WeekendDrive.Interview.Mini.Project.Bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Round {

	@Id
	@GeneratedValue
	private int id;

	private String name;

	private int sequence;

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


}
