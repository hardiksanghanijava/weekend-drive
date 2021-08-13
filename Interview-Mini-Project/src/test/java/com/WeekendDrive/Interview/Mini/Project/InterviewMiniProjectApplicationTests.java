package com.WeekendDrive.Interview.Mini.Project;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.weekend.drive.interview.controller.IntervieweeController;

@SpringBootTest
@RunWith(SpringRunner.class)
@WebMvcTest(value = IntervieweeController.class)
class InterviewMiniProjectApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;

	//@MockBean
	//private IntervieweeServiceImpl service;
	
//	@Test
//	//List retrieveAll() {
//		//return service.findAll();
//	}

}
