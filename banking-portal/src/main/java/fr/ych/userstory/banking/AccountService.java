package fr.ych.userstory.banking;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findById(int id);
    
    List<Account> findAllByClient(Client client);


    Account update(Account account);
    
    OutputOperationMessage deposit(Account account,double amount);
    
    OutputOperationMessage withdrawal(Account account,double amount);

}


