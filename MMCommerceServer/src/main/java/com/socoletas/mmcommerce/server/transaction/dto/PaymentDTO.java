package com.socoletas.mmcommerce.server.transaction.dto;

import java.math.BigDecimal;

public class PaymentDTO {
	
	private String creditor;
	private BigDecimal amount;
	private String password;
	
	public String getCreditor() {
		return creditor;
	}
	public void setCreditor(String creditor) {
		this.creditor = creditor;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

	
	
}
