package fr.ych.userstory.banking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ych.userstory.banking.model.Operation;
import fr.ych.userstory.banking.repo.OperationRepository;
import fr.ych.userstory.banking.service.OperationService;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository repository;

    public Operation create(Operation operation) {
        return repository.save(operation);
    }

    public List<Operation> findAll() {
        return repository.findAll();
    }

    public Operation findById(int id) {
        return repository.findOne(id);
    }

	public List<Operation> findAllByAccount(int accountId) {
		return repository.findAllByAccount(accountId);
	}
}
