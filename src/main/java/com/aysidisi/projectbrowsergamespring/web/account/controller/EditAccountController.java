
package com.aysidisi.projectbrowsergamespring.web.account.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.projectbrowsergamespring.web.account.controller.helper.AccountValidator;
import com.aysidisi.projectbrowsergamespring.web.account.model.Account;
import com.aysidisi.projectbrowsergamespring.web.account.service.AccountService;
import com.aysidisi.projectbrowsergamespring.web.core.ViewManager;
import com.aysidisi.projectbrowsergamespring.web.core.ViewTemplate;

@Controller
public class EditAccountController
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = "/account/", method = RequestMethod.GET, params = "edit")
	public ModelAndView editAccount()
	{
		ModelAndView modelAndView = new ModelAndView(
				ViewManager.generateViewName(ViewTemplate.mainTemplate,
						"account/editAccount"));
		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		this.initView(modelAndView,
				this.accountService.findByName(authentication.getName()));
		return modelAndView;
	}
	
	public void initView(final ModelAndView modelAndView, final Account account)
	{
		modelAndView.addObject("account", account);
	}

	@RequestMapping(value = "/account", method = RequestMethod.POST, params = "edit")
	public ModelAndView updateAccount(@ModelAttribute final Account account)
	{
		ModelAndView modelAndView;
		List<String> errors = this.accountValidator.validateAccount(account);
		if (errors.isEmpty())
		{
			List<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
			account.setAuthorities(authorities);
			this.accountService.save(account);
			modelAndView = new ModelAndView("redirect:/login?accountCreated");
		}
		else
		{
			modelAndView = new ModelAndView(ViewManager.generateViewName(
					ViewTemplate.mainTemplate, "account/editAccount"));
			this.initView(modelAndView, account);
			modelAndView.addObject("errors", errors);
		}
		return modelAndView;
	}
}
