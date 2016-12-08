package com.socoletas.mmcommerce.server.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.socoletas.mmcommerce.server.account.dao.AccountRepository;
import com.socoletas.mmcommerce.server.account.domain.Account;
import com.socoletas.mmcommerce.server.account.dto.AccountDTO;
import com.socoletas.mmcommerce.server.account.dto.BalanceDTO;

@RestController
public class AccountController {
    
	private AccountRepository accountRepository;
	
    @RequestMapping("/login")
    public void doLogin() {
    	
    }
    
    @RequestMapping("/balance")
    @ResponseBody
    public BalanceDTO getBalance() {
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	String loggedUser = auth.getName();
    	Account loggedAccount = accountRepository.findOne(loggedUser);
    	BalanceDTO balance = new BalanceDTO();
    	
    	balance.setBalance(loggedAccount.getBalance());
    	balance.setCeiling(loggedAccount.getCeiling());
    	
    	return balance;
    	
    }
    
    @RequestMapping("/signup")
    public void doSignup(@RequestBody AccountDTO pUser) {
    	Account user = accountRepository.findOne(pUser.getUsername());
    	if (user!=null)
    	{
    		throw new RuntimeException("User already exists");
    	}
    	Account account = new Account();
    	if (pUser.getPassword()==null || pUser.getPassword().isEmpty())
    	{
    		throw new RuntimeException("Empty password not allowed");
    	}
    	account.setPassword(pUser.getPassword());
    	account.setUsername(pUser.getUsername());
    	accountRepository.save(account);
    	
    }

    @Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
    
    
    
}
