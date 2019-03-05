package fr.ych.userstory.banking;

import java.util.List;

public interface ClientService {

    Client create(Client client);

    Client delete(int id);

    List<Client> findAll();

    Client findById(int id);

    Client update(Client client);
}


