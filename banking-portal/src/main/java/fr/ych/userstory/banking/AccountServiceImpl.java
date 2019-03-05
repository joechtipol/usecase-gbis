package fr.ych.userstory.banking;

import java.sql.Time;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository repository;
    
    @Autowired
    private OperationRepository operationRepository;


    @Override
    public List<Account> findAll() {
        return repository.findAll();
    }

    @Override
    public Account findById(int id) {
        return repository.findOne(id);
    }

    @Override
    public Account update(Account account) {
        return repository.save(account);
    }

    @Override
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
      
      operation.setOperationDate(LocalDate.now());
      account.setBalance(account.getBalance()+amount);
      operationRepository.save(operation);
      account=update(account);	
      
      outputOperationMessage.setStatus("Ok");
	  outputOperationMessage.setStatus("your deposit of "+amount+" was succefully done and your new balance is ="+account.getBalance());

	  return outputOperationMessage;
	}

    @Override
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
      
      operation.setOperationDate(LocalDate.now());
      account.setBalance(account.getBalance()-amount);
      operationRepository.save(operation);
      account=update(account);	
      
      outputOperationMessage.setStatus("Ok");
	  outputOperationMessage.setStatus("your withdrawal of "+amount+" was succefully done and your new balance is ="+account.getBalance());

	  return outputOperationMessage;
	}

	public List<Account> findAllByClient(Client client) {
		// TODO Auto-generated method stub
		return null;
	}
}
