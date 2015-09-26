
package com.aysidisi.plainspringwebapp.web.core;

import org.springframework.web.servlet.ModelAndView;

public class ViewManager
{
	static public ModelAndView generateModelAndView(final ViewTemplate template, final String view)
	{
		ModelAndView modelAndView = new ModelAndView(template.getPath());
		modelAndView.addObject("view", "views/" + view);
		return modelAndView;
	}
}
