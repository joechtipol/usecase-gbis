package fr.ych.userstory.banking.service;

import java.util.List;

import fr.ych.userstory.banking.model.Account;
import fr.ych.userstory.banking.model.Client;
import fr.ych.userstory.banking.model.OutputOperationMessage;

public interface AccountService {

    List<Account> findAll();

    Account findById(int id);
    
    List<Account> findAllByClient(Client client);


    Account update(Account account);
    
    OutputOperationMessage deposit(Account account,double amount);
    
    OutputOperationMessage withdrawal(Account account,double amount);

}


