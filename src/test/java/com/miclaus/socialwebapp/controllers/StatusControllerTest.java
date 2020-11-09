package com.miclaus.socialwebapp.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.miclaus.socialwebapp.Service.StatusService;
import com.miclaus.socialwebapp.models.Status;

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
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.model().attribute("status", new Status()))
				.andExpect(MockMvcResultMatchers.model().attribute("latestStatus", new Status("testing...")))
				.andExpect(MockMvcResultMatchers.view().name("app.addstatus"))
				.andDo(MockMvcResultHandlers.print());
		
	}
	
}
