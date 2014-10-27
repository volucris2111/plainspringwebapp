
package com.aysidisi.projectbrowsergamespring.web.account.dao;

import com.aysidisi.projectbrowsergamespring.web.account.model.Account;

public interface AccountDao

{
	public Account findByName(String name);
	
	public void save(Account account);
	
}
