
package com.aysidisi.plainspringwebapp.config.cache;

import java.util.HashMap;

import org.bson.types.ObjectId;

import com.aysidisi.plainspringwebapp.web.account.model.Account;

public class WebSocketSessionCache
{
	private static WebSocketSessionCache INSTANCE = new WebSocketSessionCache();

	public static WebSocketSessionCache getInstance()
	{
		return INSTANCE;
	}
	
	private final HashMap<String, HashMap<ObjectId, Account>> cache = new HashMap<String, HashMap<ObjectId, Account>>();

	private WebSocketSessionCache()
	{
	}

	public HashMap<String, HashMap<ObjectId, Account>> getWebSocketSessionCache()
	{
		return this.cache;
	}

	public HashMap<ObjectId, Account> getWebSocketSessionCacheBySubject(final String subject)
	{
		return this.cache.get(subject);
	}
}