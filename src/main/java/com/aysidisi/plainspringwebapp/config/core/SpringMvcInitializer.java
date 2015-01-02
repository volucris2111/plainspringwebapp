
package com.aysidisi.plainspringwebapp.config.core;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.aysidisi.plainspringwebapp.config.AppConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
{
	
	@Override
	public void onStartup(final ServletContext servletContext) throws ServletException
	{
		FilterRegistration.Dynamic encodingFilter = servletContext.addFilter("encoding-filter",
				new CharacterEncodingFilter());
		encodingFilter.setInitParameter("encoding", "UTF-8");
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, true, "/*");
		super.onStartup(servletContext);
	}
	
	@Override
	protected Class<?>[] getRootConfigClasses()
	{
		return new Class[]
		{ AppConfig.class };
	}
	
	@Override
	protected Class<?>[] getServletConfigClasses()
	{
		return null;
	}
	
	@Override
	protected String[] getServletMappings()
	{
		return new String[]
		{ "/" };
	}
	
}
