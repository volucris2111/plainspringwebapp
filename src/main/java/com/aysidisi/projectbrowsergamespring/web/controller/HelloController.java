
package com.aysidisi.projectbrowsergamespring.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.projectbrowsergamespring.web.account.model.Account;
import com.aysidisi.projectbrowsergamespring.web.account.service.AccountService;

@Controller
public class HelloController
{
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage()
	{
		ModelAndView model = new ModelAndView();
		Account account = new Account();
		account.setName("Aysidisi");
		account.setPassword("dayum");
		accountService.save(account);
		Account storedAccount = accountService.findByName("Aysidisi");
		System.out.println(storedAccount.getPassword());
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Admin Page!");
		model.setViewName("admin");
		return model;
		
	}
	
	@RequestMapping(value = "/dba**", method = RequestMethod.GET)
	public ModelAndView dbaPage()
	{
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is protected page - Database Page!");
		model.setViewName("admin");
		return model;
		
	}
	
	@RequestMapping(value =
	{ "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView welcomePage()
	{
		
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Hello World");
		model.addObject("message", "This is welcome page!");
		model.setViewName("hello");
		return model;
		
	}
	
}