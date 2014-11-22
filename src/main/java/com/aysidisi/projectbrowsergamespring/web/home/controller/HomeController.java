
package com.aysidisi.projectbrowsergamespring.web.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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
	
	@MessageMapping("/connect")
	public void connect(final SimpMessageHeaderAccessor headerAccessor) throws Exception
	{
		// if (ChatTest.getInstance().getChats().get(1) == null)
		// {
		// ChatTest.getInstance().getChats().put(1, new HashSet<String>());
		// }
		// if (!ChatTest.getInstance().getChats().get(1)
		// .contains(SecurityContextHolder.getContext().getAuthentication().getName()))
		// {
		// ChatTest.getInstance().getChats().get(1)
		// .add(SecurityContextHolder.getContext().getAuthentication().getName());
		// }
		this.messagingTemplate.convertAndSend("/chat/connect", headerAccessor.getUser().getName()
				+ " ist beigetreten!");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home()
	{
		return new ModelAndView(
				ViewManager.generateViewName(ViewTemplate.mainTemplate, "core/home"));
	}

	@MessageMapping("/message")
	public void sendMessage(final String message, final SimpMessageHeaderAccessor headerAccessor)
			throws Exception
	{
		this.messagingTemplate.convertAndSend("/chat/message", headerAccessor.getUser().getName()
				+ ": " + message);
	}
}
