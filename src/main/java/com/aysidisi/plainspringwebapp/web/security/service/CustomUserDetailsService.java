
package com.aysidisi.plainspringwebapp.web.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aysidisi.plainspringwebapp.web.account.dao.AccountDao;
import com.aysidisi.plainspringwebapp.web.account.model.Account;

@Service
public class CustomUserDetailsService implements UserDetailsService
{
	
	@Autowired
	private AccountDao accountDao;
	
	@Override
	public Account loadUserByUsername(final String name) throws UsernameNotFoundException
	{
		Account account = this.accountDao.findByName(name);
		if (account == null)
		{
			throw new UsernameNotFoundException("FUUUU");
		}
		return account;
	}

}
