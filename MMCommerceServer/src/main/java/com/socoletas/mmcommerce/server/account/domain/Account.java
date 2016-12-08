package com.socoletas.mmcommerce.server.account.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@Column(nullable = false)
	private String username;
	
	@Column(nullable = false)
	private String password;
	
	@Column
	private BigDecimal ceiling;
	
	@Column
	private BigDecimal balance;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public BigDecimal getCeiling() {
		return ceiling;
	}
	public void setCeiling(BigDecimal ceiling) {
		this.ceiling = ceiling;
	}
	public BigDecimal getBalance() { 
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	
	
	

}
