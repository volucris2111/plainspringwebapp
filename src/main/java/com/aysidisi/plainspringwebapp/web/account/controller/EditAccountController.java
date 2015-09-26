
package com.aysidisi.plainspringwebapp.web.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class EditAccountController
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private AccountValidator accountValidator;

	@RequestMapping(value = "/account/", method = RequestMethod.GET, params = "edit")
	public ModelAndView editAccount()
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
				"account/editAccount");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		this.initView(modelAndView, this.accountService.findByName(authentication.getName()));
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
			this.accountService.saveOnlyEditableFields(account);
			modelAndView = new ModelAndView("redirect:/login?accountCreated");
		}
		else
		{
			modelAndView = ViewManager.generateModelAndView(ViewTemplate.mainTemplate,
					"account/editAccount");
			this.initView(modelAndView, account);
			modelAndView.addObject("errors", errors);
		}
		return modelAndView;
	}
}
