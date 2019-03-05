package fr.ych.userstory.banking;

import java.util.List;

public interface OperationService {

	Operation create(Operation operation);

    List<Operation> findAll();
    
    List<Operation> findAllByAccount(int accountId);


    Operation findById(int id);
}


