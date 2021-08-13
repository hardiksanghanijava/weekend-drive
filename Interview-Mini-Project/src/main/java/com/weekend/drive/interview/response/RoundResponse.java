package com.weekend.drive.interview.response;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Round;



public class RoundResponse {
	
	private int id;
	private String name;
	private int sequence;
	
	public RoundResponse() {}
	
	public RoundResponse(int id, String name, int sequence) {
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
	@Override
	public String toString() {
		return "RoundResponse [id=" + id + ", name=" + name + ", sequence=" + sequence + "]";
	}
	
	public Round toRoundResponseEntity(RoundResponse roundResponse) throws IllegalAccessException, InvocationTargetException {
		Round round = new Round();
		BeanUtils.copyProperties(round, roundResponse);
		return round;
	}
}
