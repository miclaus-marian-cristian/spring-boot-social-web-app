package com.miclaus.socialwebapp.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.miclaus.socialwebapp.models.Status;
import com.miclaus.socialwebapp.service.StatusService;

@WebMvcTest(StatusController.class)
public class StatusControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StatusService statusService; 
	
	@Test
	public void testGetAddStatusPage() throws Exception {
		
		Mockito.when(statusService.getLatest())
										.thenReturn(new Status("testing..."));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/addstatus"))
				.andExpect(status().isOk())
				.andExpect(model().attribute("status", new Status()))
				.andExpect(model().attribute("latestStatus", new Status("testing...")))
				.andExpect(view().name("app.addstatus"))
				.andDo(print());
		
	}
	
}
