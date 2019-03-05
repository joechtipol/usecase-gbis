package fr.ych.userstory.banking;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {
	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(sequenceName = "operation_seq", allocationSize = 1, name = "OPERATION_SEQ")
    private int id;

	
    @Column
    private double amount;
    @Column(name = "date_operation")
    private LocalDate operationDate;
    
    
    public LocalDate getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(LocalDate operationDate) {
		this.operationDate = operationDate;
	}
	@ManyToOne
    @JoinColumn(name="id_account")
    private Account account;
    
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

}
