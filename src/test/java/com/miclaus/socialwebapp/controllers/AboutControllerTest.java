package com.miclaus.socialwebapp.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest(AboutController.class)
public class AboutControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Test
	public void testAboutController() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/about"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("app.about"))
				.andDo(MockMvcResultHandlers.print());
	}
	
}
