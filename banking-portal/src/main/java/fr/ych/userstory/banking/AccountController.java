package fr.ych.userstory.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    
    @PostMapping(path = {"/{id}/deposit/{amount}"})
    public OutputOperationMessage deposit(@PathVariable("id") int id,@PathVariable("amount") double amount, @RequestBody Account account){
        account.setId(id);
        return accountService.deposit(account, amount);
    }

    @GetMapping(path = {"/{id}/operations"})
    public List<Operation> findAllOperations(@PathVariable("id") int id){
        return operationService.findAllByAccount(id);
    }
    
    
    
    @GetMapping
    public List<Account> findAll(){
        return accountService.findAll();
    }
}
