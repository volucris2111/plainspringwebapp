
package com.aysidisi.projectbrowsergamespring.web.account.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

@Repository
public interface AccountDao extends MongoRepository<Account, Integer>
{
	public Account findByName(String name);
}
