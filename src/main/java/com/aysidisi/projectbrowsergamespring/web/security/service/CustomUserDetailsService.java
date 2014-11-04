
package com.aysidisi.projectbrowsergamespring.web.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aysidisi.projectbrowsergamespring.web.account.dao.AccountDao;
import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

@Service
public class CustomUserDetailsService implements UserDetailsService
{

	@Autowired
	private AccountDao accountDao;

	@Override
	public UserDetails loadUserByUsername(final String name)
			throws UsernameNotFoundException
	{
		Account account = accountDao.findByName(name);
		return new User(account.getName(), account.getPassword(),
				account.getAuthorities());
	}
}
