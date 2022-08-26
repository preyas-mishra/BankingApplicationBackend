package com.banking.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.main.model.LoanApplication;
import com.banking.main.repository.LoanApplicationRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class LoanController {
	@Autowired
	private LoanApplicationRepository applicationRepository;
	
	@PostMapping("/loanapply")
	public LoanApplication applyLoan(@RequestBody LoanApplication application) {
		return applicationRepository.save(application);
	}
	
	@GetMapping("/loanapplications")
	public List<LoanApplication> getAllApplications() {
		return applicationRepository.findAll();
	}
}
