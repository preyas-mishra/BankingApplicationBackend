package com.banking.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.main.model.Account;
import com.banking.main.model.Customer;
import com.banking.main.repository.AccountRepository;
import com.banking.main.repository.CustomerRepository;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"} )
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping("/account/max")
	public Long getMaxAccountNo() {
		return accountRepository.maxAccountNo();
	}
	
	@PostMapping("/newuser")
	public Customer setCustomer(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}
	
	@GetMapping("/allusers")
	public List<Customer> getAllCustomer(){
		return customerRepository.findAll();
	}
	
	@PutMapping("/customer/{cid}")
	public Customer updateApprovalStatus(@PathVariable("cid")Long cid,@RequestBody Customer customer) {
		Customer custDB = customerRepository.getById(cid);
		if(customer.getApprovalStatus()!=null)
			custDB.setApprovalStatus("Approved");
		return customerRepository.save(custDB);
	}
	
	@GetMapping("/customer/account/{cid}")
	public Account getAccountByCustId(@PathVariable("cid")Long cid) {
		return accountRepository.getByCustomerId(cid);
	}
	
	@GetMapping("/customer/{cid}")
	public Customer getCustById(@PathVariable("cid")Long cid) {
		return customerRepository.getById(cid);
	}
	
	@DeleteMapping("/customer/{cid}")
	public void deleteCustomerById(@PathVariable("cid") Long cid) {
		customerRepository.deleteById(cid);
	}
}
