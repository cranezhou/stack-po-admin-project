/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import com.rillsoft.stackpoadmin.domain.User;

/**
 * @author crane
 *
 */
public interface IUserService {

	User getUserById(Integer Id);
	
    User selectByUsername(String strUsername);
    
//    PageInfo<User> selectByPage(User user, int start, int length);
}
