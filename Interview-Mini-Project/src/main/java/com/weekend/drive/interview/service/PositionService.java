package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Optional;

import com.weekend.drive.interview.bean.Positions;
import com.weekend.drive.interview.request.PositionsRequest;
import com.weekend.drive.interview.request.PositionsUpdateRequest;
import com.weekend.drive.interview.response.PositionsResponse;

public interface PositionService
{

	List<PositionsResponse> getAllPositions();
	PositionsResponse getPositionById(int id);
	Positions createPosition(PositionsRequest positionsRequest) throws IllegalAccessException, InvocationTargetException;
	Positions updatePosition(PositionsUpdateRequest positionsUpdateRequest) throws IllegalAccessException, InvocationTargetException;
	Optional<Positions> deletePosition(int id);
	
}
