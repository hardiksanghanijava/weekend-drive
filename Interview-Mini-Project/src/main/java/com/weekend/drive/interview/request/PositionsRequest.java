package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Positions;


public class PositionsRequest {

	private String name;
	private String description;
	
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

	public PositionsRequest(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public static Positions toPositionRequestEnttity(PositionsRequest positionsRequest) throws IllegalAccessException, InvocationTargetException {
		Positions positions = new Positions();
		BeanUtils.copyProperties(positions, positionsRequest);
		return positions;
	}
	
	

}
