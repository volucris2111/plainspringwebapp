
package com.aysidisi.plainspringwebapp.web.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.plainspringwebapp.web.account.dao.AccountDao;
import com.aysidisi.plainspringwebapp.web.account.model.Account;

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
		Account storedAccount = accountDao.findByName(account.getName());
		if (storedAccount != null)
		{
			storedAccount.setMail(account.getMail());
			storedAccount.setName(account.getName());
			storedAccount.setPassword(account.getPassword());
			storedAccount.setAuthorities(account.getAuthorities());
		}
		else
		{
			storedAccount = account;
		}
		accountDao.save(storedAccount);
	}
}
