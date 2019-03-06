package fr.ych.userstory.banking.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ych.userstory.banking.model.Account;
import fr.ych.userstory.banking.model.Client;
import fr.ych.userstory.banking.model.Operation;
import fr.ych.userstory.banking.model.OutputOperationMessage;
import fr.ych.userstory.banking.repo.AccountRepository;
import fr.ych.userstory.banking.repo.OperationRepository;
import fr.ych.userstory.banking.service.AccountService;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;
    
    @Autowired
    private OperationRepository operationRepository;


    public List<Account> findAll() {
        return repository.findAll();
    }

    public Account findById(int id) {
        return repository.findOne(id);
    }

    public Account update(Account account) {
        return repository.save(account);
    }

	public OutputOperationMessage deposit(Account account, double amount) {
	      OutputOperationMessage outputOperationMessage=new OutputOperationMessage();

		if(amount<0)
		{
			outputOperationMessage.setStatus("Ko");
			outputOperationMessage.setStatus("Sorry, you can not do a deposit of non positiv value");
            return outputOperationMessage;
		}
	
      Operation operation=new Operation();
      operation.setAccount(account);
      operation.setAmount(amount);
      
     // operation.setOperationDate(LocalDate.now());
      operationRepository.save(operation);

      account.setBalance(account.getBalance()+amount);
      account=update(account);	
      
      outputOperationMessage.setStatus("Ok");
	  outputOperationMessage.setStatus("your deposit of "+amount+" was succefully done and your new balance is ="+account.getBalance());

	  return outputOperationMessage;
	}

	public OutputOperationMessage withdrawal(Account account, double amount) {
		OutputOperationMessage outputOperationMessage=new OutputOperationMessage();

		if(amount>account.getBalance())
		{
			outputOperationMessage.setStatus("Ko");
			outputOperationMessage.setStatus("Your amount is greater than your balance");
            return outputOperationMessage;
		}
		
      Operation operation=new Operation();
      operation.setAccount(account);
      operation.setAmount(amount);
      
      //operation.setOperationDate(LocalDate.now());
      operationRepository.save(operation);

      account.setBalance(account.getBalance()-amount);
      account=update(account);	
      
      outputOperationMessage.setStatus("Ok");
	  outputOperationMessage.setMessage("your withdrawal of "+amount+" was succefully done and your new balance is ="+account.getBalance());

	  return outputOperationMessage;
	}

	public List<Account> findAllByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
}
