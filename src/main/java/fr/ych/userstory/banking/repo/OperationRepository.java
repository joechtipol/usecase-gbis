package fr.ych.userstory.banking.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import fr.ych.userstory.banking.model.Operation;

import java.util.List;

public interface OperationRepository extends Repository<Operation, Integer> {


    List<Operation> findAll();
    
    @Query(value="select * from operation where id_account=?1",nativeQuery=true)
    List<Operation> findAllByAccount(int accountId);

    Operation findOne(int id);

    Operation save(Operation client);
}
