package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Positions;

public class PositionsUpdateRequest
{
	private int id;
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

	public PositionsUpdateRequest(int id,String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static Positions toPositionRequestEnttity(PositionsUpdateRequest positionsUpdateRequest) throws IllegalAccessException, InvocationTargetException {
		Positions positions = new Positions();
		BeanUtils.copyProperties(positions, positionsUpdateRequest);
		return positions;
	}
	
}

