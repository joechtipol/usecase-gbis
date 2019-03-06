package fr.ych.userstory.banking.repo;

import org.springframework.data.repository.Repository;

import fr.ych.userstory.banking.model.Account;
import fr.ych.userstory.banking.model.Client;

import java.util.List;

public interface AccountRepository extends Repository<Account, Integer> {


    List<Account> findAll();
    
    List<Account> findAllByClient(Client client);

    Account findOne(int id);

    Account save(Account client);
}
