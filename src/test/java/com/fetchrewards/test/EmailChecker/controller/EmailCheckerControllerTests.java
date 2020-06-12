package com.fetchrewards.test.EmailChecker.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fetchrewards.test.EmailChecker.service.EmailCheckerService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmailCheckerControllerTests {

	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private EmailCheckerService emailChecker;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void shouldReturnUniqueEmailCount_SUCCESS() throws Exception {
		
    	when(emailChecker.uniqueEmailCount(Mockito.any())).thenReturn(1);
	    
		this.mockMvc
			.perform(post("/email/check")
                    .contentType(MediaType.APPLICATION_JSON).content("[\"test.email@gmail.com\", \"test.email+spam@gmail.com\",\"testemail@gmail.com\"]"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$").value("1"));
	}

}
