
package com.aysidisi.projectbrowsergamespring.web.account.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aysidisi.projectbrowsergamespring.web.account.dao.AccountDao;
import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

@Component
public class AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	public Account findByName(final String name)
	{
		return accountDao.findByName(name);
	}

	public void save(final Account account)
	{
		accountDao.save(account);
	}
}
