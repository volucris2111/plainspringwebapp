
package com.aysidisi.projectbrowsergamespring.web.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.projectbrowsergamespring.web.account.service.AccountService;
import com.aysidisi.projectbrowsergamespring.web.core.ViewManager;
import com.aysidisi.projectbrowsergamespring.web.core.ViewTemplate;

@Controller
public class HomeController
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;
	
	@MessageMapping("/testreg")
	@SendTo("/test1/dayum")
	public String greeting() throws Exception
	{
		return "Hello, bloit!";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home()
	{
		this.messagingTemplate.convertAndSend("/test1/dayum", "bloit bloit!");
		return new ModelAndView(ViewManager.generateViewName(
				ViewTemplate.mainTemplate, "core/home"));
	}
}
