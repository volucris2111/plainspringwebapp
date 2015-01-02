
package com.aysidisi.plainspringwebapp.config.cache;

import java.math.BigInteger;
import java.util.HashMap;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public class WebSocketSessionCache
{
	private static WebSocketSessionCache INSTANCE = new WebSocketSessionCache();
	
	public static HashMap<String, HashMap<BigInteger, Account>> getInstance()
	{
		return INSTANCE.getWebSocketSessionCache();
	}
	
	private HashMap<String, HashMap<BigInteger, Account>> webSocketSessionCache = new HashMap<String, HashMap<BigInteger, Account>>();
	
	private WebSocketSessionCache()
	{
	}
	
	public HashMap<String, HashMap<BigInteger, Account>> getWebSocketSessionCache()
	{
		return this.webSocketSessionCache;
	}
	
	public void setWebSocketSessionCache(
			final HashMap<String, HashMap<BigInteger, Account>> webSocketSessionCache)
	{
		this.webSocketSessionCache = webSocketSessionCache;
	}
}
