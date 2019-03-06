package fr.ych.userstory.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.ych.userstory.banking.model.Account;
import fr.ych.userstory.banking.model.Operation;
import fr.ych.userstory.banking.model.OutputOperationMessage;
import fr.ych.userstory.banking.service.AccountService;
import fr.ych.userstory.banking.service.OperationService;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping({"/api/account"})
//@RequestMapping({"/users"})
public class AccountController {

    @Autowired
    private AccountService accountService;
    
    @Autowired
    private OperationService operationService;


    @GetMapping(path = {"/{id}"})
    public Account findOne(@PathVariable("id") int id){
        return accountService.findById(id);
    }

    @PutMapping(path = {"/{id}"})
    public Account update(@PathVariable("id") int id, @RequestBody Account account){
        account.setId(id);
        return accountService.update(account);
    }
    
    @RequestMapping(value = "/{id}/deposit", method = RequestMethod.POST)
    public OutputOperationMessage deposit(@PathVariable("id") int id,@RequestParam("amount")  double amount, @RequestBody Account account){
        account.setId(id);
        return accountService.deposit(account, amount);
    }
    
    @RequestMapping(value = "/{id}/withdrawal", method = RequestMethod.POST)
    public OutputOperationMessage withdrawal(@PathVariable("id") int id,@RequestParam("amount")  double amount, @RequestBody Account account){
        account.setId(id);
        return accountService.withdrawal(account, amount);
    }

    @PostMapping(path = {"/{id}/operations"})
    public List<Operation> findAllOperations(@PathVariable("id") int id){
        return operationService.findAllByAccount(id);
    }
    
    
    
    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }
}
