package com.banking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.banking.main.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
	@Query("select MAX(e.accountNo) from Account e")
	Long maxAccountNo();


	Account getByAccountNo(Long aid);
	
	Account getByCustomerId(Long cid);

	

}
