package com.fetchrewards.test.EmailChecker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fetchrewards.test.EmailChecker.service.EmailCheckerService;

@RestController
@RequestMapping("/email")
public class EmailCheckerController {
	
	@Autowired
	EmailCheckerService emailChecker;

	@PostMapping("/check")
	public int emailCheck(@RequestBody List<String> emails) {
		
		return emailChecker.uniqueEmailCount(emails);
	}

}
