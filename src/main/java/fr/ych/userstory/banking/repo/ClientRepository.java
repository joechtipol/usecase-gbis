package fr.ych.userstory.banking.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import fr.ych.userstory.banking.model.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository extends Repository<Client, Integer> {

    void delete(Client client);

    List<Client> findAll();

    Client findOne(int id);

    Client save(Client client);
    
    @Query(value="select * from client where login=?1",nativeQuery=true)
    Optional<Client> findUserWithName(String username);

}
