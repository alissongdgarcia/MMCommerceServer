package com.socoletas.mmcommerce.server.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socoletas.mmcommerce.server.authentication.dao.AccountRepository;
import com.socoletas.mmcommerce.server.authentication.domain.Account;
import com.socoletas.mmcommerce.server.transaction.dao.TransactionRepository;
import com.socoletas.mmcommerce.server.transaction.domain.Transaction;
import com.socoletas.mmcommerce.server.transaction.dto.PaymentDTO;

@RestController
public class TransactionController {
    
	private TransactionRepository transactionRepository;
	private AccountRepository accountRepository;
	
    @RequestMapping("/payment")
    public void doPayment(@RequestBody PaymentDTO pPaymentDTO) {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String loggedUser = auth.getName();
    	Account loggedAccount = accountRepository.findOne(loggedUser);
    	String creditor = pPaymentDTO.getCreditor();
    	Account creditorAccount = accountRepository.findOne(creditor);
    	Transaction transaction = new Transaction();
    	transaction.setDebtor(loggedAccount);
    	transaction.setCreditor(creditorAccount);
    	transaction.setType("Payment");
    	transaction.setAmount(pPaymentDTO.getAmount());
    	if (!loggedAccount.getPassword().equals(pPaymentDTO.getPassword()))
    	{
    		throw new RuntimeException("Wrong confirmation password");
    	}
    	transactionRepository.save(transaction);
    }
    
    

    @Autowired
	public void setTransactionRepository(TransactionRepository transactionRepository) {
		this.transactionRepository = transactionRepository;
	}
    
    @Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
    
    
    
}
