
package com.aysidisi.projectbrowsergamespring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesView;

@EnableWebMvc
@Configuration
@ComponentScan(
{ "com.aysidisi.projectbrowsergamespring.web.*" })
@EnableMongoRepositories("com.aysidisi.projectbrowsergamespring.web.*")
@Import(
{ SecurityConfig.class, SpringMongoConfig.class, TilesConfig.class })
public class AppConfig extends WebMvcConfigurerAdapter
{
	@Bean
	public ViewResolver viewResolver()
	{
		UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
		viewResolver.setViewClass(TilesView.class);
		return viewResolver;
	}
}