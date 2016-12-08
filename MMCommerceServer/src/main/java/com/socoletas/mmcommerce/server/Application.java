package com.socoletas.mmcommerce.server;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import com.socoletas.mmcommerce.server.account.dao.AccountRepository;
import com.socoletas.mmcommerce.server.account.domain.Account;

@Controller
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@RequestMapping("/")
    @ResponseBody
    String home() {
      return "Welcome to MMCommerce APP!!";
    }

	@Bean
    CommandLineRunner init(final AccountRepository accountRepository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... arg0) throws Exception {
        	Account account = new Account();
        	account.setUsername("admin");
        	account.setPassword("admin");
        	accountRepository.save(account);
        	
        	
        	account = new Account();
        	account.setUsername("danilo");
        	account.setPassword("danilo123");
        	account.setBalance(BigDecimal.valueOf(500));
        	account.setCeiling(BigDecimal.valueOf(200));
        	accountRepository.save(account);
        	
        	account = new Account();
        	account.setUsername("carol");
        	account.setPassword("carol123");
        	account.setBalance(BigDecimal.valueOf(800));
        	account.setCeiling(BigDecimal.valueOf(300));
        	accountRepository.save(account);
        	
        	account = new Account();
        	account.setUsername("alisson");
        	account.setPassword("alisson123");
        	account.setBalance(BigDecimal.valueOf(1500));
        	account.setCeiling(BigDecimal.valueOf(100));
        	accountRepository.save(account);
        	
        	account = new Account();
        	account.setUsername("affonso");
        	account.setPassword("affonso123");
        	account.setBalance(BigDecimal.valueOf(2500));
        	account.setCeiling(BigDecimal.valueOf(500));
        	accountRepository.save(account);
        	
        	account = new Account();
        	account.setUsername("tiberio");
        	account.setPassword("tiberio123");
        	account.setBalance(BigDecimal.valueOf(4500));
        	account.setCeiling(BigDecimal.valueOf(500));
        	accountRepository.save(account);
        	

        }
        
      };

    }
}

@Configuration
class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	AccountRepository accountRepository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Bean
	UserDetailsService userDetailsService() {
		return new UserDetailsService() {

			@Override
			public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
				Account account = accountRepository.findOne(username);
				if(account != null) {
					return new User(account.getUsername(), account.getPassword(), true, true, true, true,
							AuthorityUtils.createAuthorityList("USER"));
				} else {
					throw new UsernameNotFoundException("could not find the user '"
							+ username + "'");
				}
			}

		};
	}
}

@EnableWebSecurity
@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/signup");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().
		httpBasic().and().
		csrf().disable();
		
		http.headers().frameOptions().disable();
		
	}

}
