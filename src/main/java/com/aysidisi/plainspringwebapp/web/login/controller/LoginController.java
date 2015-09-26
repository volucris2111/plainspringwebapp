
package com.aysidisi.plainspringwebapp.web.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class LoginController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) final String error,
			@RequestParam(value = "accountCreated", required = false) final String accountCreated,
			@RequestParam(value = "logout", required = false) final String logout)
	{
		ModelAndView modelAndView = ViewManager.generateModelAndView(ViewTemplate.bodyOnly,
				"login/login");
		if (error != null)
		{
			modelAndView.addObject("error", "Invalid username and password!");
		}
		if (logout != null)
		{
			modelAndView.addObject("msg", "You've been logged out successfully.");
		}
		if (accountCreated != null)
		{
			modelAndView.addObject("msg", "Account created successfully. Please loggin.");
		}
		return modelAndView;
	}
}
