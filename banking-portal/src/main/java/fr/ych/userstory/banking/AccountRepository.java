package fr.ych.userstory.banking;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface AccountRepository extends Repository<Account, Integer> {


    List<Account> findAll();
    
    List<Account> findAllByClient(Client client);

    Account findOne(int id);

    Account save(Account client);
}
