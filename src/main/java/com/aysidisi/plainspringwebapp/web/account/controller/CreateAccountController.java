
package com.aysidisi.plainspringwebapp.web.account.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.controller.helper.AccountValidator;
import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class CreateAccountController
{
	@Autowired
	private AccountService accountService;

	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public ModelAndView createAccount()
	{
		ModelAndView modelAndView = new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.bodyOnly, "account/createAccount"));
		List<GrantedAuthority> authorities = new LinkedList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		this.initView(modelAndView, new Account());
		return modelAndView;
	}

	public void initView(final ModelAndView modelAndView, final Account account)
	{
		modelAndView.addObject("account", account);
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView saveAccount(@ModelAttribute final Account account)
	{
		ModelAndView modelAndView;
		List<String> errors = this.accountValidator.validateAccount(account);
		if (errors.isEmpty())
		{
			List<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			account.setAuthorities(authorities);
			account.setEnabled(true);
			this.accountService.save(account);
			modelAndView = new ModelAndView("redirect:/login?accountCreated");
		}
		else
		{
			modelAndView = new ModelAndView("account/createAccount");
			this.initView(modelAndView, account);
			modelAndView.addObject("errors", errors);
		}
		return modelAndView;
	}

}
