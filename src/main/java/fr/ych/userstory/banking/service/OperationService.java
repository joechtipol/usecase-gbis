package fr.ych.userstory.banking.service;

import java.util.List;

import fr.ych.userstory.banking.model.Operation;

public interface OperationService {

	Operation create(Operation operation);

    List<Operation> findAll();
    
    List<Operation> findAllByAccount(int accountId);


    Operation findById(int id);
}


