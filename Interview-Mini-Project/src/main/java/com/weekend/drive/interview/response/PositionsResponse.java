package com.weekend.drive.interview.response;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Positions;
import com.weekend.drive.interview.bean.ScheduleInterview;

public class PositionsResponse<T> 
{
	private int id;
	private String name;
	private String description;
	private List<ScheduleInterview> scheduleInterview = new ArrayList<>();	
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
	
	public PositionsResponse(int id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	public PositionsResponse() {
		
	}
	public static PositionsResponse toPositionResponseEntity(Positions positions) throws IllegalAccessException, InvocationTargetException {
		PositionsResponse positionsResponse = new PositionsResponse();
		BeanUtils.copyProperties(positionsResponse, positions);
		return positionsResponse;
	}
	
}
