package com.socoletas.mmcommerce.server.transaction.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.socoletas.mmcommerce.server.transaction.domain.Transaction;

@RepositoryRestResource
public interface TransactionRepository extends CrudRepository<Transaction, String> {

}
