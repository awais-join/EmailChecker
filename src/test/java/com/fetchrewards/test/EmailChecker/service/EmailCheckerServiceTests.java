package com.fetchrewards.test.EmailChecker.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class EmailCheckerServiceTests {

    @TestConfiguration
    static class EmailCheckerServiceTestContextConfiguration {
  
        @Bean
        public EmailCheckerService emailCheckerService() {
            return new EmailCheckerService();
        }
        
    }
    
    @Autowired
    private EmailCheckerService emailCheckerService;
	
    @Test
    public void whenFindUser_thenUserShouldBeFound() {
    	// given
    	List<String> emails = new ArrayList<>();
    	emails.add("test.email@gmail.com");
    	emails.add("test.email+spam@gmail.com");
    	emails.add("testemail@gmail.com");
    	
    	// when
        int expected = emailCheckerService.uniqueEmailCount(emails);
      
        // then
        assertEquals(expected, 1);
        
     }

}
