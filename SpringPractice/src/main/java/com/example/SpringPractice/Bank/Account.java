package com.example.SpringPractice.Bank;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @SequenceGenerator(
            name = "bank_id_sequence",
            sequenceName = "bank_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
         strategy = GenerationType.SEQUENCE,
         generator = "bank_id_sequence"
    )

    private Long account_number;
    private String name;

    private  String  password;

    private int balance;

    public Account() {
    }



    public Account(Long account_number, String name, String password, int balance) {
        this.account_number = account_number;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public Account(String name, String password, int balance) {
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Account(Long account_number, String name, String password) {
        this.account_number = account_number;
        this.name = name;
        this.password = password;
    }

    public Long getAccount_number() {
        return account_number;
    }

    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "account_number=" + account_number +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
