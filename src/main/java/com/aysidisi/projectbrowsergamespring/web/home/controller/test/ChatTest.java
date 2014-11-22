
package com.aysidisi.projectbrowsergamespring.web.home.controller.test;

import java.util.HashMap;
import java.util.Set;

public class ChatTest
{
	private static ChatTest INSTANCE = new ChatTest();
	
	public static ChatTest getInstance()
	{
		return INSTANCE;
	}
	
	private HashMap<Integer, Set<String>> chats = new HashMap<Integer, Set<String>>();
	
	private ChatTest()
	{
	}
	
	public HashMap<Integer, Set<String>> getChats()
	{
		return this.chats;
	}

	public void setChats(final HashMap<Integer, Set<String>> chats)
	{
		this.chats = chats;
	}

}
