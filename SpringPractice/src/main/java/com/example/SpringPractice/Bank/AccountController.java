package com.example.SpringPractice.Bank;

import com.example.SpringPractice.User.ClientInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "bank")
public class AccountController {
    private final AccountService accountService;
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public String home(){
        return "index";
    }

    @GetMapping(path = "/sign_up")
    public String sign_in(){
        return "create_account";
    }

//    @GetMapping(path = "sign_in")
//    public String login(){
//        return "login";
//    }

    @GetMapping(path = "transfer")
    public String transaction(){
        return "transfer";
    }

    @GetMapping (path= "home")
    public String clientHome(Model model){
        model.addAttribute("user",accountService.user());
        return "client_home";
    }





    @PostMapping (path = "/register")
    public String registerNewClient ( Account client){
        accountService.addNewClient(client);
        return home();
    }
    @DeleteMapping (path = "delete")
    //name and password
    public String deleteAccount(ClientInfo client){
        accountService.deleteAccount(client);
        return home();
    }
    @PostMapping (path = "/login")
    //name and password
    public String login(ClientInfo client, Model model){

//        return "redirect:/home";
        try {
            accountService.login(client);
            return clientHome(model);
        }
        catch (IllegalStateException e){
            model.addAttribute("error", e.getMessage());
            return home();
        }

    }
    @PostMapping(path = "transaction")
    //name / password/ toSendTo/ amount
    public String transaction(ClientInfo client, Model model){

        try {
            accountService.transaction(client);
            return clientHome(model);
        }
        catch (IllegalStateException e){
            model.addAttribute("error", e.getMessage());
            return transaction();
        }
    }
//    @GetMapping(path = "balance")
//    // name/ password
//    public int getBalance(){
//        return accountService.getBalance();
//    }

//    @GetMapping(path = "withdraw")
//    // name/ password/ amount
//    public String withdraw(@RequestBody ClientInfo client){
//        return accountService.withdraw(client);
//    }

//    @PutMapping (path = "deposit")
//    // name/ password/ amount
//    public String deposit(@RequestBody ClientInfo client){
//        return accountService.deposit(client);
//    }

}
