
package com.aysidisi.plainspringwebapp.web.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.plainspringwebapp.web.core.ViewManager;
import com.aysidisi.plainspringwebapp.web.core.ViewTemplate;

@Controller
public class HomeController
{
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home()
	{
		return ViewManager.generateModelAndView(ViewTemplate.mainTemplate, "core/home");
	}
	
}
