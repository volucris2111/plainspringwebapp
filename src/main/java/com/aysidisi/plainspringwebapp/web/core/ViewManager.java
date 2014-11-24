
package com.aysidisi.plainspringwebapp.web.core;


public class ViewManager
{
	static public String generateViewName(final ViewTemplate template,
			final String viewName)
	{
		return template + "|" + viewName;
	}
}
