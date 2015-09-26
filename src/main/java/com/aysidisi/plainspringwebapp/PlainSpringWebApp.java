
package com.aysidisi.plainspringwebapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.aysidisi.plainspringwebapp.config.AppConfig;
import com.aysidisi.plainspringwebapp.config.SecurityConfig;
import com.aysidisi.plainspringwebapp.config.SpringMongoConfig;
import com.aysidisi.plainspringwebapp.config.ThymeleafConfig;
import com.aysidisi.plainspringwebapp.config.WebSocketConfig;

@EnableAutoConfiguration
@Configuration
@Import(
{ SecurityConfig.class, SpringMongoConfig.class, ThymeleafConfig.class, WebSocketConfig.class,
		AppConfig.class })
public class PlainSpringWebApp extends SpringBootServletInitializer
{
	public static void main(final String[] args)
	{
		SpringApplication.run(PlainSpringWebApp.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(final SpringApplicationBuilder application)
	{
		return application.sources(PlainSpringWebApp.class);
	}
}
