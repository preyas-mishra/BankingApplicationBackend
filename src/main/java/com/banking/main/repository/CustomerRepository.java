package com.banking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.main.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

	Customer getByEmail(String cemail);

}
