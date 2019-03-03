package com.rillsoft.stackpoadmin.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SecurityUser extends User implements UserDetails {

	public SecurityUser(Integer id, String username, String password, String fullname, String user_email,
			String user_phone, Date last_login, Date date_joined, Integer user_status) {
		super(id, username, password, fullname, user_email, user_phone, last_login, date_joined, user_status);
		// TODO Auto-generated constructor stub
	}
	
	// added by crane zhou on 11.03.2018
	public SecurityUser(User user)
	{
		if (user != null)
		{
			this.setId(user.getId());
			this.setUsername(user.getUsername());
			this.setPassword(user.getPassword());
			this.setFullname(user.getFullname());
			this.setUser_email(user.getUser_email());
			this.setUser_phone(user.getUser_phone());
			this.setLast_login(user.getLast_login());
			this.setDate_joined(user.getDate_joined());
			this.setUser_status(user.getUser_status());
		}
	}

	public SecurityUser() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
//		return null;
        List<GrantedAuthority> auths = new ArrayList<>();
//        List<SysRole> roles = getRoles();
//        for(SysRole role : roles)
        {
            // auths.add(new SimpleGrantedAuthority(role.getName()));
        	auths.add(new SimpleGrantedAuthority("Administrator"));
        	auths.add(new SimpleGrantedAuthority("Normal User"));
        }
        return auths;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		// return false;
		return true;
	}

}
