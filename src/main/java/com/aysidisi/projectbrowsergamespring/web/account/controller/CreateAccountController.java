
package com.aysidisi.projectbrowsergamespring.web.account.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.projectbrowsergamespring.web.account.model.Account;
import com.aysidisi.projectbrowsergamespring.web.account.service.AccountService;

@Controller
public class CreateAccountController
{
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/account", method = RequestMethod.GET, params = "create")
	public ModelAndView createAccount()
	{
		ModelAndView modelAndView = new ModelAndView("account/createAccount");
		initView(modelAndView, new Account());
		return modelAndView;
	}
	
	public void initView(final ModelAndView modelAndView, final Account account)
	{
		modelAndView.addObject("account", account);
	}
	
	@RequestMapping(value = "/account", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute final Account account)
	{
		ModelAndView modelAndView;
		List<String> errors = validateAccount(account);
		if (errors.isEmpty())
		{
			List<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			account.setAuthorities(authorities);
			accountService.save(account);
			modelAndView = new ModelAndView("redirect:/login?accountCreated");
		}
		else
		{
			modelAndView = new ModelAndView("account/createAccount");
			initView(modelAndView, account);
			modelAndView.addObject("errors", errors);
		}
		return modelAndView;
	}
	
	public List<String> validateAccount(final Account account)
	{
		List<String> errors = new LinkedList<String>();
		if (account.getName() == null || account.getName().isEmpty()
				|| account.getPassword() == null
				|| account.getPassword().isEmpty() || account.getMail() == null
				|| account.getMail().isEmpty())
		{
			errors.add("Pflichtfelder!");
		}
		else if (accountService.findByName(account.getName()) != null)
		{
			errors.add("Name bereits vorhanden!");
		}
		return errors;
	}
}
