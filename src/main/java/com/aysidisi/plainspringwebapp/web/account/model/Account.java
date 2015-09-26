
package com.aysidisi.plainspringwebapp.web.account.model;

import java.util.Collection;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Document(collection = "accounts")
@TypeAlias("account")
public class Account implements UserDetails
{
	
	private static final long serialVersionUID = 3224498846412363389L;
	
	private Boolean accountNonExpired;

	private Boolean accountNonLocked;

	private Collection<SimpleGrantedAuthority> authorities;
	
	private Boolean credentialsNonExpired;
	
	private ObjectId currentAvatarId;

	private Boolean enabled;
	
	@Id
	private ObjectId id;
	
	private String mail;
	
	private String name;
	
	private String password;
	
	public Boolean getAccountNonExpired()
	{
		return this.accountNonExpired == null ? true : this.accountNonExpired;
	}
	
	public Boolean getAccountNonLocked()
	{
		return this.accountNonLocked == null ? true : this.accountNonLocked;
	}
	
	@Override
	public Collection<SimpleGrantedAuthority> getAuthorities()
	{
		return this.authorities;
	}
	
	public Boolean getCredentialsNonExpired()
	{
		return this.credentialsNonExpired == null ? true : this.credentialsNonExpired;
	}
	
	public ObjectId getCurrentAvatarId()
	{
		return this.currentAvatarId;
	}

	public Boolean getEnabled()
	{
		return this.enabled == null ? true : this.enabled;
	}
	
	public ObjectId getId()
	{
		return this.id;
	}
	
	public String getMail()
	{
		return this.mail;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	@Override
	public String getPassword()
	{
		return this.password;
	}
	
	@Override
	public String getUsername()
	{
		return this.name;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return this.getAccountNonExpired();
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		return this.getAccountNonLocked();
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return this.getCredentialsNonExpired();
	}
	
	@Override
	public boolean isEnabled()
	{
		return this.getEnabled();
	}

	public void setAccountNonExpired(final boolean accountNonExpired)
	{
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonExpired(final Boolean accountNonExpired)
	{
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(final boolean accountNonLocked)
	{
		this.accountNonLocked = accountNonLocked;
	}
	
	public void setAccountNonLocked(final Boolean accountNonLocked)
	{
		this.accountNonLocked = accountNonLocked;
	}

	public void setAuthorities(final Collection<SimpleGrantedAuthority> authorities)
	{
		this.authorities = authorities;
	}

	public void setCredentialsNonExpired(final boolean credentialsNonExpired)
	{
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public void setCredentialsNonExpired(final Boolean credentialsNonExpired)
	{
		this.credentialsNonExpired = credentialsNonExpired;
	}
	
	public void setCurrentAvatarId(final ObjectId currentAvatarId)
	{
		this.currentAvatarId = currentAvatarId;
	}
	
	public void setEnabled(final Boolean enabled)
	{
		this.enabled = enabled;
	}
	
	public void setId(final ObjectId id)
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
