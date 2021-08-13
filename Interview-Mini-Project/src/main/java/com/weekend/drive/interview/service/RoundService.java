package com.weekend.drive.interview.service;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import com.weekend.drive.interview.bean.Round;
import com.weekend.drive.interview.request.RoundUpdateRequest;
import com.weekend.drive.interview.response.RoundResponse;

public interface RoundService {
	
	public List<RoundResponse> getAllRounds();
	public RoundResponse getRoundById( int id) throws IllegalAccessException, InvocationTargetException;
	public void deleteRound( int id) throws IllegalAccessException, InvocationTargetException;
	public Round updateRound(RoundUpdateRequest roundUpdateRequest) throws IllegalAccessException, InvocationTargetException;

}
