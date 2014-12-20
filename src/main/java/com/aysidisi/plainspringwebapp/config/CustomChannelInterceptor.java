
package com.aysidisi.plainspringwebapp.config;

import java.math.BigInteger;
import java.util.HashMap;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import com.aysidisi.plainspringwebapp.config.cache.WebSocketSessionCache;
import com.aysidisi.plainspringwebapp.web.account.model.Account;

public class CustomChannelInterceptor implements ChannelInterceptor
{

	@Override
	public void afterReceiveCompletion(final Message<?> message, final MessageChannel channel,
			final Exception ex)
	{
		
	}

	@Override
	public void afterSendCompletion(final Message<?> message, final MessageChannel channel,
			final boolean sent, final Exception ex)
	{
		
	}

	@Override
	public Message<?> postReceive(final Message<?> message, final MessageChannel channel)
	{
		return message;
	}

	@Override
	public void postSend(final Message<?> message, final MessageChannel channel, final boolean sent)
	{
	}

	@Override
	public boolean preReceive(final MessageChannel channel)
	{
		return false;
	}

	@Override
	public Message<?> preSend(final Message<?> message, final MessageChannel channel)
	{
		SimpMessageType simpMessageType = (SimpMessageType) message.getHeaders().get(
				"simpMessageType");
		if (!simpMessageType.equals(SimpMessageType.MESSAGE))
		{
			String simpDestination = (String) message.getHeaders().get("simpDestination");
			HashMap<String, HashMap<BigInteger, Account>> webSocketSessionCache = WebSocketSessionCache
					.getInstance();
			if (simpMessageType.equals(SimpMessageType.SUBSCRIBE))
			{
				if (webSocketSessionCache.get(simpDestination) == null)
				{
					webSocketSessionCache.put(simpDestination, new HashMap<BigInteger, Account>());
				}
				Account account = (Account) ((UsernamePasswordAuthenticationToken) message
						.getHeaders().get("simpUser")).getPrincipal();
				webSocketSessionCache.get(simpDestination).put(account.getId(), account);
			}
			else if (simpMessageType.equals(SimpMessageType.DISCONNECT)
					|| simpMessageType.equals(SimpMessageType.UNSUBSCRIBE))
			{
				Account account = (Account) ((UsernamePasswordAuthenticationToken) message
						.getHeaders().get("simpUser")).getPrincipal();
				for (String key : webSocketSessionCache.keySet())
				{
					webSocketSessionCache.get(key).remove(account.getId());
				}
			}
		}
		return message;
	}
}
