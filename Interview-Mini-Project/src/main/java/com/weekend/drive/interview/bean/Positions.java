package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.BeanUtils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.weekend.drive.interview.response.PositionsResponse;

import lombok.Data;

@Entity
@Table(name = "positions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
@Data
public class Positions 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Size(min=2, message="Name should have atleast 2 characters")
	private String name;
	private String description;
	
	@OneToMany(mappedBy="positions")
	private List<ScheduleInterview> scheduleInterview = new ArrayList<>();
	
	

	public static PositionsResponse toPositionResponseEnttity(Positions positions) throws IllegalAccessException, InvocationTargetException {
		PositionsResponse positionsResponse = new PositionsResponse();
		BeanUtils.copyProperties(positionsResponse, positions);
		return positionsResponse;
	}

		
}
