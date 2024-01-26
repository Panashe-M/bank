package com.example.SpringPractice.User;



public class ClientInfo {
    private Long account_number;
    private String name;
    private String password;
    private Integer balance;
    private int amount;
    private long toSendTo;

    public ClientInfo() {
    }

    public ClientInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public ClientInfo(String name, String password, int amount) {
        this.name = name;
        this.password = password;
        this.amount = amount;
    }


    public ClientInfo(Long account_number, String name, String password, Integer balance, int amount, long toSendTo) {
        this.account_number = account_number;
        this.name = name;
        this.password = password;
        this.balance = balance;
        this.amount = amount;
        this.toSendTo = toSendTo;
    }

    public ClientInfo(int amount, long toSendTo) {
        this.amount = amount;
        this.toSendTo = toSendTo;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
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

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getToSendTo() {
        return toSendTo;
    }

    public void setToSendTo(long toSendTo) {
        this.toSendTo = toSendTo;
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "account_number=" + account_number +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", amount=" + amount +
                ", toSendTo=" + toSendTo +
                '}';
    }
}
