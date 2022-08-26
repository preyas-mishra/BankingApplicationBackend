package com.banking.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.main.model.Account;
import com.banking.main.model.AddBalance;
import com.banking.main.model.Customer;
import com.banking.main.model.TransferMoney;
import com.banking.main.repository.AccountRepository;
import com.banking.main.repository.AddBalanceRepository;
import com.banking.main.repository.CustomerRepository;
import com.banking.main.repository.TransferMoneyRepository;

@RestController
@CrossOrigin(origins= {"http://localhost:4200/"})
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private AddBalanceRepository addBalanceRepository;
	
	@Autowired
	private TransferMoneyRepository transferMoneyRepository;
	
	@PostMapping("/account/{cid}")
	private Account postAccount(@PathVariable("cid")Long cid, @RequestBody Account account) {
		Customer customer = customerRepository.getById(cid);
		account.setCustomer(customer);
		return accountRepository.save(account);
	}
	
	@GetMapping("/account")
	private List<Account> getAccounts(){
		return accountRepository.findAll();
	}
	
	@GetMapping("/account/balance/{aid}")
	public double getBalanceById(@PathVariable("aid")Long aid) {
		return accountRepository.getById(aid).getBalance();
	}
	
	@PutMapping("/account/balance/{aid}")
	public Account postbalance(@PathVariable("aid")Long aid,@RequestBody Account account) {
		Account accDB = accountRepository.getById(aid);
		double prevBalance = accountRepository.getById(aid).getBalance();
		accDB.setBalance(prevBalance+account.getBalance());
		return accountRepository.save(accDB);
	}
	
	@PutMapping("/account/balance/transfer/{aid}")
	public Account transferMoney(@PathVariable("aid")Long aid,@RequestBody Account account) {
		Account accDB = accountRepository.getById(aid);
		double prevBalance = accountRepository.getById(aid).getBalance();
		accDB.setBalance(prevBalance-account.getBalance());
		return accountRepository.save(accDB);
	}
	
	@PostMapping("/add/balance/{cid}")
	public AddBalance addBalanceToTable(@PathVariable("cid")Long cid, @RequestBody AddBalance addBalance) {
		Customer customer = customerRepository.getById(cid);
		addBalance.setCustomer(customer);
		return addBalanceRepository.save(addBalance);
	}
	
	@GetMapping("/account/{accNo}")
	public Account getAccountByAccountNo(@PathVariable("accNo")Long accNo) {
		return accountRepository.getByAccountNo(accNo);
	}
	
	@PostMapping("/transfer")
	public TransferMoney postDetailsOfTransfer(@RequestBody TransferMoney transferMoney) {
		return transferMoneyRepository.save(transferMoney);
	}
	
	
}
