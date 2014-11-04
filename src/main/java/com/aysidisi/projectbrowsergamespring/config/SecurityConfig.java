
package com.aysidisi.projectbrowsergamespring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.aysidisi.projectbrowsergamespring.web.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private CustomUserDetailsService customerUserDetailsService;

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth)
			throws Exception
	{
		auth.inMemoryAuthentication().withUser("mkyong").password("123456")
				.roles("USER");
		auth.inMemoryAuthentication().withUser("admin").password("123456")
				.roles("ADMIN");
		auth.inMemoryAuthentication().withUser("dba").password("123456")
				.roles("DBA");
	}
	
	@Bean
	public CustomUserDetailsService defaultUserDetailsService()
	{
		return new CustomUserDetailsService();
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http.userDetailsService(customerUserDetailsService);
		http.authorizeRequests().antMatchers("/admin/**")
		.access("hasRole('admin')").antMatchers("/dba/**")
		.access("hasRole('admin') or hasRole('dba')").and().formLogin();

	}
}