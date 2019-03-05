package fr.ych.userstory.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    @Override
    public Client create(Client client) {
        return repository.save(client);
    }

    @Override
    public Client delete(int id) {
        Client client = findById(id);
        if(client != null){
            repository.delete(client);
        }
        return client;
    }

    @Override
    public List<Client> findAll() {
        return repository.findAll();
    }

    @Override
    public Client findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Client update(Client client) {
        return repository.save(client);
    }
}
