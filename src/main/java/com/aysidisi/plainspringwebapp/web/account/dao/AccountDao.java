
package com.aysidisi.plainspringwebapp.web.account.dao;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public interface AccountDao extends MongoRepository<Account, ObjectId>
{
	Account findByName(String name);
}
