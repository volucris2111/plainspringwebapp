
package com.aysidisi.plainspringwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.aysidisi.plainspringwebapp.web.security.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	@Autowired
	private CustomUserDetailsService customerUserDetailsService;

	@Autowired
	public void configureGlobal(final AuthenticationManagerBuilder auth) throws Exception
	{
		auth.inMemoryAuthentication().withUser("admin").password("dayum2010")
		.roles("ADMIN", "USER");
	}
	
	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		http.userDetailsService(this.customerUserDetailsService).authorizeRequests()
		.antMatchers("/signup", "/login/**").permitAll().antMatchers("/admin/**")
		.access("hasRole('ROLE_ADMIN')").antMatchers("/**").access("hasRole('ROLE_USER')")
		.and().formLogin().loginPage("/login").failureUrl("/login?error")
				.usernameParameter("username").passwordParameter("password").and().logout()
		.logoutSuccessUrl("/login?logout").and().csrf();
	}
}