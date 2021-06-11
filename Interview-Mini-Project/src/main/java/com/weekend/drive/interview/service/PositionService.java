package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.weekend.drive.interview.bean.Positions;
import com.weekend.drive.interview.request.PositionsRequest;
import com.weekend.drive.interview.request.PositionsUpdateRequest;
import com.weekend.drive.interview.response.PositionsResponse;

public interface PositionService
{

	List<PositionsResponse> getAllPositions();
	PositionsResponse getPositionById(int id) throws IllegalAccessException, InvocationTargetException;
	Positions createPosition(PositionsRequest positionsRequest) throws IllegalAccessException, InvocationTargetException;
	Positions updatePosition(PositionsUpdateRequest positionsUpdateRequest) throws IllegalAccessException, InvocationTargetException;
	void deletePosition(int id) throws IllegalAccessException, InvocationTargetException;
	
}
