package com.banking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.main.model.FixedDeposit;

public interface FixedDepositRepository extends JpaRepository<FixedDeposit, Long>{

}
