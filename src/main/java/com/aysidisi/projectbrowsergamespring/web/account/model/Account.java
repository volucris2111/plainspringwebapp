
package com.aysidisi.projectbrowsergamespring.web.account.model;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.GeneratedValue;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Document(collection = "accounts")
@TypeAlias("account")
public class Account
{
	private List<SimpleGrantedAuthority> authorities;

	@Id
	@GeneratedValue
	private BigInteger id;

	private String mail;

	private String name;

	private String password;

	public List<SimpleGrantedAuthority> getAuthorities()
	{
		return authorities;
	}

	public BigInteger getId()
	{
		return id;
	}

	public String getMail()
	{
		return mail;
	}

	public String getName()
	{
		return name;
	}

	public String getPassword()
	{
		return password;
	}
	
	public void setAuthorities(final List<SimpleGrantedAuthority> authorities)
	{
		this.authorities = authorities;
	}
	
	public void setId(final BigInteger id)
	{
		this.id = id;
	}

	public void setMail(final String mail)
	{
		this.mail = mail;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

}
