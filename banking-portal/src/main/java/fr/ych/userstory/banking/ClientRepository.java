package fr.ych.userstory.banking;

import org.springframework.data.repository.Repository;

import java.util.List;

public interface ClientRepository extends Repository<Client, Integer> {

    void delete(Client client);

    List<Client> findAll();

    Client findOne(int id);

    Client save(Client client);
}
