package com.weekend.drive.interview.response;

public class InterviewerResponse {
	
	private int id;
	private int name;
	
	
	public InterviewerResponse() {
		super();
	}
	
	public InterviewerResponse(int id, int name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	
	

}
