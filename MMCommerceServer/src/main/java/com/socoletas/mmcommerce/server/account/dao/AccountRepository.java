package com.socoletas.mmcommerce.server.account.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.socoletas.mmcommerce.server.account.domain.Account;

@RepositoryRestResource
public interface AccountRepository extends CrudRepository<Account, String> {

}
