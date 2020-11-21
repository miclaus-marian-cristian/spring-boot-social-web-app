package com.miclaus.socialwebapp.controllers;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.miclaus.socialwebapp.models.Status;
import com.miclaus.socialwebapp.service.StatusService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(HomeController.class)
public class HomeControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	StatusService statusService; 
	
	@Test
	public void testHomeController() throws Exception {
		
		Mockito.when(statusService.getLatest())
				.thenReturn(new Status("testing..."));
		
		mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("app.home"))
				.andDo(print());
	}
	
}
