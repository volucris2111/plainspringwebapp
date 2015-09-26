
package com.aysidisi.plainspringwebapp.web.core;

public enum ViewTemplate
{
	bodyOnly("templates/bodyOnly/bodyOnly"), mainTemplate("templates/mainTemplate");

	private String path;
	
	ViewTemplate(final String path)
	{
		this.path = path;
	}
	
	public String getPath()
	{
		return this.path;
	}
	
	public void setPath(final String path)
	{
		this.path = path;
	}
}
