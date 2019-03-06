package fr.ych.userstory.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.ych.userstory.banking.model.Client;
import fr.ych.userstory.banking.repo.ClientRepository;
import fr.ych.userstory.banking.service.ClientService;

import java.util.List;
import java.util.Objects;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository repository;

    public Client create(Client client) {
        return repository.save(client);
    }

    public Client delete(int id) {
        Client client = findById(id);
        if(client != null){
            repository.delete(client);
        }
        return client;
    }

    public List<Client> findAll() {
        return repository.findAll();
    }

    public Client findById(int id) {
        return repository.findOne(id);
    }

    public Client update(Client client) {
        return repository.save(client);
    }
    
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{

        Objects.requireNonNull(username);
        Client user = repository.findUserWithName(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        return user;
    }
}
