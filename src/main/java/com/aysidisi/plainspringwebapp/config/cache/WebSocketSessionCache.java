
package com.aysidisi.plainspringwebapp.config.cache;

import java.util.HashMap;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public class WebSocketSessionCache
{
	private static WebSocketSessionCache INSTANCE = new WebSocketSessionCache();
	
	public static HashMap<String, HashMap<String, Account>> getInstance()
	{
		return INSTANCE.getWebSocketSessionCache();
	}
	
	private HashMap<String, HashMap<String, Account>> webSocketSessionCache = new HashMap<String, HashMap<String, Account>>();
	
	private WebSocketSessionCache()
	{
	}
	
	public HashMap<String, HashMap<String, Account>> getWebSocketSessionCache()
	{
		return this.webSocketSessionCache;
	}
	
	public void setWebSocketSessionCache(
			final HashMap<String, HashMap<String, Account>> webSocketSessionCache)
	{
		this.webSocketSessionCache = webSocketSessionCache;
	}
}
