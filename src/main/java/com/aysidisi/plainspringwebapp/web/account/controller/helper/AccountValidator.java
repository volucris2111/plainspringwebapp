
package com.aysidisi.plainspringwebapp.web.account.controller.helper;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;

@Component
public class AccountValidator
{
	@Autowired
	private AccountService accountService;
	
	public List<String> validateAccount(final Account account)
	{
		List<String> errors = new LinkedList<String>();
		Account storedAccount = this.accountService.findByName(account.getName());
		if (account.getName() == null || account.getName().isEmpty()
				|| account.getPassword() == null || account.getPassword().isEmpty()
				|| account.getMail() == null || account.getMail().isEmpty())
		{
			errors.add("Pflichtfelder!");
		}
		else if (account.getName().equals("admin") || storedAccount != null
				&& storedAccount.getId() != account.getId())
		{
			errors.add("Name bereits vergeben!");
		}
		return errors;
	}
}
