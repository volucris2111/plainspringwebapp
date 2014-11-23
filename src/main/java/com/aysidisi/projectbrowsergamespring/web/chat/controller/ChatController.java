
package com.aysidisi.projectbrowsergamespring.web.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.aysidisi.projectbrowsergamespring.web.core.ViewManager;
import com.aysidisi.projectbrowsergamespring.web.core.ViewTemplate;

@Controller
public class ChatController
{
	@RequestMapping(value = "/chat", method = RequestMethod.GET)
	public ModelAndView home()
	{
		return new ModelAndView(
				ViewManager.generateViewName(ViewTemplate.mainTemplate, "chat/chat"));
	}
}
