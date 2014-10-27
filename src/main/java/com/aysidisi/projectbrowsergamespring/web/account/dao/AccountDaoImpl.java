
package com.aysidisi.projectbrowsergamespring.web.account.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao
{
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager entityManager;

	public void createAccount(final Account account)
	{
		entityManager.persist(account);
		entityManager.flush();
		
	}

	@Override
	public Account findByName(final String name)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(final Account account)
	{
		// TODO Auto-generated method stub
		
	}
	
}
