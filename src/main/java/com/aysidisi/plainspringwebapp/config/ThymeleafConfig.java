
package com.aysidisi.plainspringwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.resourceresolver.SpringResourceResourceResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
public class ThymeleafConfig extends SpringTemplateEngine
{
	
	@Bean
	public ITemplateResolver defaultTemplateResolver()
	{
		TemplateResolver resolver = new TemplateResolver();
		resolver.setResourceResolver(this.thymeleafResourceResolver());
		resolver.setPrefix("/WEB-INF/");
		resolver.setSuffix(".html");
		resolver.setTemplateMode("HTML5");
		resolver.setOrder(1);
		resolver.setCacheable(false);
		return resolver;
	}
	
	@Bean
	public SpringTemplateEngine templateEngine()
	{
		SpringTemplateEngine engine = new SpringTemplateEngine();
		engine.setTemplateResolver(this.defaultTemplateResolver());
		engine.addDialect(new SpringSecurityDialect());
		return engine;
	}

	@Bean
	public SpringResourceResourceResolver thymeleafResourceResolver()
	{
		return new SpringResourceResourceResolver();
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver()
	{
		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
		resolver.setTemplateEngine(this.templateEngine());
		resolver.setContentType("text/html; charset=UTF-8");
		return resolver;
	}
}
