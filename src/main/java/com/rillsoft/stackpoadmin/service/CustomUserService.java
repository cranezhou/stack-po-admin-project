/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rillsoft.stackpoadmin.domain.SecurityUser;
import com.rillsoft.stackpoadmin.domain.User;
import com.rillsoft.stackpoadmin.mapper.UserMapper;

/**
 * @author crane
 *
 */
@Service
public class CustomUserService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    
	/**
	 * 
	 */
	public CustomUserService() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.core.userdetails.UserDetailsService#loadUserByUsername(java.lang.String)
	 */
	
	@Override
	public UserDetails loadUserByUsername(String strUsername) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<User> userList = userMapper.selectByUsername(strUsername);
		
		if (userList == null)
		{
			throw new UsernameNotFoundException("UserName " + strUsername + " not found");
		}
		else
		{
			if (userList.size() > 0){
				User objUser = userList.get(0);
				SecurityUser objSecurityUser = new SecurityUser(objUser); 
				return objSecurityUser;
			}
	    }
		return null;
	}

/* 
 * 
 * SimpleGrantedAuthority
 * List<Permission> 
 * List<GrantedAuthority>
 * List<SimpleGrantedAuthority>
 * 
 * */
}
