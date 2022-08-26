package com.banking.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.main.model.FixedDeposit;
import com.banking.main.repository.FixedDepositRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class DepositController {
	@Autowired
	private FixedDepositRepository depositRepository;
	
	@GetMapping("/deposit")
	private List<FixedDeposit> getAllDeposits() {
		return depositRepository.findAll();
	}
	
	@PostMapping("/deposit")
	private FixedDeposit postNewDeposit(@RequestBody FixedDeposit fixedDeposit) {
		return depositRepository.save(fixedDeposit);
	}
}
