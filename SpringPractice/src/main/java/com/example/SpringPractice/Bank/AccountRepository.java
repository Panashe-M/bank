package com.example.SpringPractice.Bank;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface
AccountRepository extends JpaRepository<Account,Long>{
    @Override
    Optional<Account> findById(Long account_number);
     Optional<Account> findBankByName(String name);


}
