package com.weekend.drive.interview.mail;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.weekend.drive.interview.bean.ScheduleInterview;
import com.weekend.drive.interview.repository.ScheduleInterviewRepository;

@Component
public class EmailService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ScheduleInterviewRepository scheduleinterviewRepository;
	
	public void sentMail(String name, String email) {
		
		// Create a mail sender
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.mailtrap.io");
	    mailSender.setPort(2525);
	    mailSender.setUsername("576fb849e7eef7");
	    mailSender.setPassword("e62758dafb1585");
	
	    // Create an email instance
	    SimpleMailMessage mailMessage = new SimpleMailMessage();
	    mailMessage.setFrom("weekend-e82a26@inbox.mailtrap.io");
	    mailMessage.setTo(email);
	    mailMessage.setSubject("New notification from Weekend Drive");
	    mailMessage.setText("Hello, " + name + "\n\tYour scheduled interview begins in one hour");
	
	    // Send mail
	    mailSender.send(mailMessage);
	}
	
	//Scheduler
	@Scheduled(fixedRate = 3600000)
	public void interviwScheduler() {
		logger.info("Scheduler");
	}
		
	@Scheduled(fixedRate = 60000)
	public void notifyScheduler() {
		// Fetch Schedule Interview
		List<ScheduleInterview> scheduleInterview = scheduleinterviewRepository.findAll();
			
		//Current time
		LocalDateTime currentTime = LocalDateTime.now();
		
		//Iterating using stream()
		scheduleInterview.stream().forEach(interview -> {
			//Interview Time
			Date scheduleTime = interview.getTime(); 
			
			//Converting Date to LocalDateTime
			LocalDateTime time =  scheduleTime.toInstant().atZone(ZoneId.of("UTC+00:00")).toLocalDateTime();
				
			//Comparing time of hour
			long mins = ChronoUnit.MINUTES.between(currentTime, time);
				
			if(mins == 59) {
				sentMail(interview.getInterviewee().getName(), "interviewee@notify.com");
				sentMail(interview.getInterviewer().getName(), "interviewer@notify.com");
				logger.info("Email Sent Successfully");	
			}	
		});	
	}
}
