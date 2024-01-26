package com.example.SpringPractice.Bank;

import com.example.SpringPractice.User.ClientInfo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private ClientInfo user= new ClientInfo();
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository= accountRepository;
    }

    public ClientInfo user(){
        return user;
    }

    public void addNewClient(Account client) {
        accountRepository.save(client);
    }



    public void login(ClientInfo client) {
        java.util.Optional<Account> bankOptional= accountRepository.findBankByName(client.getName());
        if(bankOptional.isPresent()){
            Account account= bankOptional.get();
           if(account.getPassword().equals(client.getPassword())){
               this.user.setName(client.getName());
               this.user.setPassword(client.getPassword());
               this.user.setAccount_number(account.getAccount_number());
               this.user.setBalance(account.getBalance());

           }
           else {
           throw new IllegalStateException("incorrect password");
           }
        }
        else {
            throw new IllegalStateException("account doesn't exist");
        }

    }
    public int getBalance() {
//        int balance=0;
//        if (login(client).equals("welcome "+ client.getName())) {
        Account account= accountRepository.findById(user.getAccount_number()).get();
        //        }

        return account.getBalance();
    }

    @Transactional
    public void transaction(ClientInfo client) {
        java.util.Optional<Account> recipient= accountRepository.findById(client.getToSendTo());


//        if(login(client).equals("welcome "+ client.getName())){
            Account sender= accountRepository.findById(user.getAccount_number()).get();
            int balance= sender.getBalance();

            if(recipient.isPresent() && balance>= client.getAmount()){
//              change the balance of the user
                sender.setBalance(balance- client.getAmount());
                user.setBalance(balance- client.getAmount());
//              change balance of the recipient
                Account toRecieve= recipient.get();
                toRecieve.setBalance(toRecieve.getBalance()+ client.getAmount());
            }
            else
                throw new IllegalStateException("insufficient fund or incorrect account number");

//        }
//        else
//            throw new IllegalStateException("something is wrong");
    }
    @Transactional
    public void deleteAccount(ClientInfo client) {
        Account account= accountRepository.findById(user.getAccount_number()).get();
        accountRepository.delete(account);

//        else
//            throw new IllegalStateException("incorrect account number or password");
    }



//    @Transactional
//    public String withdraw(ClientInfo client) {
//        String toReturn="";
//        if (login(client).equals("welcome "+ client.getName())){
//            Account account= accountRepository.findBankByName(client.getName()).get();
//            int balance =account.getBalance();
//            if(balance>= client.getAmount()){
//                account.setBalance(balance- client.getAmount());
//                toReturn="withdrawal successful. new balance= "+ account.getBalance();
//            }
//            else
//                toReturn= "insufficient funds";
//        }
//        else
//            throw new IllegalStateException("incorrect name or password");
//        return toReturn;
//    }

//    @Transactional
//    public String deposit(ClientInfo client) {
//        String toReturn="";
//        if (login(client).equals("welcome "+ client.getName())){
//            Account account= accountRepository.findBankByName(client.getName()).get();
//            int balance =account.getBalance();
//            account.setBalance(balance+ client.getAmount());
//            toReturn="deposit successful. new balance= "+ account.getBalance();
//        }
//        else
//            throw new IllegalStateException("incorrect name or password");
//        return toReturn;
//    }
}
