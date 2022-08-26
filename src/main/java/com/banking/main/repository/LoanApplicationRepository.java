package com.banking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.main.model.LoanApplication;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

}
