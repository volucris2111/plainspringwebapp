
package com.aysidisi.projectbrowsergamespring.web.account.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Document(collection = "account")
public class Account
{
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date createdDate;
	
	@Id
	private String id;

	private String mail;

	private String name;

	private String password;

	private String role;

	public Date getCreatedDate()
	{
		return createdDate;
	}

	public String getId()
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

	public String getRole()
	{
		return role;
	}

	public void setCreatedDate(final Date createdDate)
	{
		this.createdDate = createdDate;
	}
	
	public void setId(final String id)
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

	public void setRole(final String role)
	{
		this.role = role;
	}
}
