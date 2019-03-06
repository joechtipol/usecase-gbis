package fr.ych.userstory.banking.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.ych.userstory.banking.model.Client;

public interface ClientService extends UserDetailsService{

    Client create(Client client);

    Client delete(int id);

    List<Client> findAll();

    Client findById(int id);

    Client update(Client client);
    
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}


