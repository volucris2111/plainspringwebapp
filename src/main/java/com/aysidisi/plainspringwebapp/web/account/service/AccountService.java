
package com.aysidisi.plainspringwebapp.web.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aysidisi.plainspringwebapp.web.account.dao.AccountDao;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.security.service.CustomUserDetailsService;

@Service
public class AccountService
{
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	public void delete(final Account account)
	{
		this.accountDao.delete(account);
	}
	
	public List<Account> findAll()
	{
		return this.accountDao.findAll();
	}
	
	public Account findByName(final String name)
	{
		return this.accountDao.findByName(name);
	}

	public void save(final Account account)
	{
		Account storedAccount = this.accountDao.findByName(account.getName());
		if (storedAccount != null)
		{
			storedAccount.setMail(account.getMail());
			storedAccount.setName(account.getName());
			storedAccount.setPassword(account.getPassword());
		}
		else
		{
			storedAccount = account;
		}
		this.accountDao.save(storedAccount);
	}
}
