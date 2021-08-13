package com.weekend.drive.interview.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.weekend.drive.interview.response.RoundResponse;

import lombok.Data;



@Entity
@DynamicUpdate
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","scheduleInterview"})
@Data
public class Round {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Size(min=3, message="name should be more than 2 letters")
	private String name;

	private int sequence;
	
	@OneToMany(mappedBy="round")
	List<ScheduleInterview> scheduleInterview = new ArrayList<>();


	
	@Override
	public String toString() {
		return "Round [id=" + id + ", name=" + name + ", sequence=" + sequence + "]";
	}

	
	public static RoundResponse toRoundEntityResponse(Round round) throws IllegalAccessException, InvocationTargetException {
		RoundResponse roundResponse = new RoundResponse();
		BeanUtils.copyProperties(roundResponse, round);
		return roundResponse;


	}
}