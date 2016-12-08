package com.socoletas.mmcommerce.server.account.dto;

import java.math.BigDecimal;

public class BalanceDTO {
	private BigDecimal balance;
	private BigDecimal ceiling;
	
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public BigDecimal getCeiling() {
		return ceiling;
	}
	public void setCeiling(BigDecimal ceiling) {
		this.ceiling = ceiling;
	}
	
	

}
