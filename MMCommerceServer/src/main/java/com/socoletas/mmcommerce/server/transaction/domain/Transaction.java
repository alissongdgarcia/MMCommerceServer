package com.socoletas.mmcommerce.server.transaction.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.socoletas.mmcommerce.server.authentication.domain.Account;

@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private BigDecimal amount;
	
	@Column
	private String type;
	
	@OneToOne(optional=false)
	private Account creditor;
	
	@OneToOne(optional=false)
	private Account debtor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Account getCreditor() {
		return creditor;
	}

	public void setCreditor(Account creditor) {
		this.creditor = creditor;
	}

	public Account getDebtor() {
		return debtor;
	}

	public void setDebtor(Account debtor) {
		this.debtor = debtor;
	}
	
	
	
	
	
	

}
