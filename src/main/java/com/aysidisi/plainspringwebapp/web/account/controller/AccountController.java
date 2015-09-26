
package com.aysidisi.plainspringwebapp.web.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.account.model.Account;
import com.aysidisi.plainspringwebapp.web.account.service.AccountService;
import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class AccountController
{
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/account/", method = RequestMethod.GET)
	public ModelAndView account()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"account/account");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.initView(modelAndView, this.accountService.findByName(authentication.getName()));
		return modelAndView;
	}
	
	public void initView(final ModelAndView modelAndView, final Account account)
	{
		modelAndView.addObject("account", account);
	}
}
