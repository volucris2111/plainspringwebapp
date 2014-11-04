
package com.aysidisi.projectbrowsergamespring.web.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.projectbrowsergamespring.web.account.dao.AccountDao;
import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

@Service
public class AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	public void delete(final Account account)
	{
		accountDao.delete(account);
	}
	
	public List<Account> findAll()
	{
		return accountDao.findAll();
	}
	
	public Account findByName(final String name)
	{
		return accountDao.findByName(name);
	}

	public void save(final Account account)
	{
		accountDao.save(account);
	}
}
