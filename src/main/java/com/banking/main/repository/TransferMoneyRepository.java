package com.banking.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.main.model.TransferMoney;

public interface TransferMoneyRepository extends JpaRepository<TransferMoney, Long>{

}
