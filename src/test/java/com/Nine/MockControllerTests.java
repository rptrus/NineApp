package com.Nine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import com.Nine.rest.NineController;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockControllerTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private NineController myController;

	
	@Before
	public void init() {
        mockMvc = MockMvcBuilders.standaloneSetup(myController).build();
        System.out.println(mockMvc);
	}
	
	@Test
	public void nicePath() {
		String json = Const.file; 
		try {
			mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void emptyJson() {
		String json ="{}";
		try {
			mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().is2xxSuccessful());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	@Test
	public void badPath() {
		String json ="{*";
		try {
			mockMvc.perform(post("/").contentType(MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().is4xxClientError());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


}



