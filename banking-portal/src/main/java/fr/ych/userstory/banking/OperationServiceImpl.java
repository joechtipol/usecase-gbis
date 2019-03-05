package fr.ych.userstory.banking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository repository;

    @Override
    public Operation create(Operation operation) {
        return repository.save(operation);
    }

    @Override
    public List<Operation> findAll() {
        return repository.findAll();
    }

    @Override
    public Operation findById(int id) {
        return repository.findOne(id);
    }

    @Override
	public List<Operation> findAllByAccount(int accountId) {
		return repository.findAllByAccount(accountId);
	}
}
