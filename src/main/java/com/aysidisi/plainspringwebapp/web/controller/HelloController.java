
package com.aysidisi.plainspringwebapp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class HelloController
{

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage()
	{
		ModelAndView model = ViewManager.generateModelAndView(ViewTemplate.bodyOnly, "admin");
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		return model;
	}
}