package com.socoletas.mmcommerce.server.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.socoletas.mmcommerce.server.authentication.dao.AccountRepository;
import com.socoletas.mmcommerce.server.authentication.domain.Account;
import com.socoletas.mmcommerce.server.authentication.dto.AccountDTO;

@RestController
public class AuthenticationController {
    
	private AccountRepository accountRepository;
	
    @RequestMapping("/login")
    public void doLogin() {
    	
    }
    
    @RequestMapping("/signup")
    public void doSignup(@RequestBody AccountDTO pUser) {
    	Account user = accountRepository.findOne(pUser.getUsername());
    	if (user!=null)
    	{
    		throw new RuntimeException("User already exists");
    	}
    	Account account = new Account();
    	account.setPassword(pUser.getPassword());
    	account.setUsername(pUser.getUsername());
    	accountRepository.save(account);
    	
    }

    @Autowired
	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}
    
    
    
}
