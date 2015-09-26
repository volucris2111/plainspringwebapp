
package com.aysidisi.plainspringwebapp.web.chat.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import com.aysidisi.plainspringwebapp.web.account.service.AccountService;

@Controller
public class ChatWebsocket
{
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private SimpMessageSendingOperations messagingTemplate;

	@MessageMapping("/connect")
	public void connect(final SimpMessageHeaderAccessor headerAccessor) throws Exception
	{
		this.messagingTemplate.convertAndSend("/chat/connect", headerAccessor.getUser().getName()
				+ " ist beigetreten!");
	}
	
	@MessageMapping("/message")
	public void sendMessage(final String message, final SimpMessageHeaderAccessor headerAccessor)
			throws Exception
	{
		this.messagingTemplate.convertAndSend("/chat/message", headerAccessor.getUser().getName()
				+ ": " + message);
	}
}
