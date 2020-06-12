package com.fetchrewards.test.EmailChecker.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
public class EmailCheckerService {

	public int uniqueEmailCount(List<String> emails) {
		
		Set<String> uniqueEmails = new HashSet<>();
		
		for(String email: emails) {
			String id = email.substring(0, email.indexOf("@"));
			id = id.replace(".", "");
			if (id.contains("+"))
				id = id.substring(0, id.indexOf("+"));
			uniqueEmails.add(id);
		}
		
		return uniqueEmails.size();
	}

}
