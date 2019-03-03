/**
 * 
 */
package com.rillsoft.stackpoadmin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rillsoft.stackpoadmin.domain.User;
import com.rillsoft.stackpoadmin.mapper.UserMapper;
import com.rillsoft.stackpoadmin.service.IUserService;

/**
 * @author crane
 *
 */
@Component
@Service
// @CacheConfig(cacheNames = "Users")
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper userMapper;
    
	/**
	 * 
	 */
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.rillsoft.stackpoadmin.service.IUserService#getUserById(java.lang.Integer)
	 */
	@Override
	public User getUserById(Integer Id) {
		// TODO Auto-generated method stub
		// return null;
		
//    	System.err.println("not go through cache！ (UserId:" + id + ")");
//      UserExample example=new UserExample();
//      example.createCriteria().andIdEqualTo(id);
    	User user = userMapper.selectByPrimaryKey(Id);
      return user;
	}

	/* (non-Javadoc)
	 * @see com.rillsoft.stackpoadmin.service.IUserService#selectByUsername(java.lang.String)
	 */
	@Override
	public User selectByUsername(String strUsername) {
		// TODO Auto-generated method stub

    	List<User> userList = userMapper.selectByUsername(strUsername);
        if(userList.size() > 0){
            return userList.get(0);
        }
		
		return null;
	}

}
