package com.socoletas.mmcommerce.server.authentication.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.socoletas.mmcommerce.server.authentication.domain.Account;

@RepositoryRestResource
public interface AccountRepository extends CrudRepository<Account, String> {

}
