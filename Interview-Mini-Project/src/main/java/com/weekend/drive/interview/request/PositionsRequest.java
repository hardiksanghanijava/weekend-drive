package com.weekend.drive.interview.request;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.weekend.drive.interview.bean.Positions;

import lombok.Data;

@Data
public class PositionsRequest {

	private String name;
	private String description;
	
	
	public static Positions toPositionRequestEnttity(PositionsRequest positionsRequest) throws IllegalAccessException, InvocationTargetException {
		Positions positions = new Positions();
		BeanUtils.copyProperties(positions, positionsRequest);
		return positions;
	}
	
	

}
