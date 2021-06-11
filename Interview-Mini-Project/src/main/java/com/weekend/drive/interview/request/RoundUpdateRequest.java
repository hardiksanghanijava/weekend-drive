package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Round;


public class RoundUpdateRequest {
	
	private int id;
	private String name;
	private int sequence;
	
	
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
		return "RoundRequest [name=" + name + ", sequence=" + sequence + "]";
	}
	
	public static Round toRoundRequestEntity(RoundUpdateRequest roundRequest) throws IllegalAccessException, InvocationTargetException {
		Round round = new Round();
		BeanUtils.copyProperties(round, roundRequest);
		return round;
	
	}

	

}
