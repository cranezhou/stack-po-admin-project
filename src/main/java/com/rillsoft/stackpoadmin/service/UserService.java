/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

// import com.admin.domain.repository.UserRepository;
// import com.admin.domain.modle.User;
import com.rillsoft.stackpoadmin.domain.User;
import com.rillsoft.stackpoadmin.mapper.UserMapper;

/**
 * @author crane
 *
 */
@Service
@CacheConfig(cacheNames = "user")
public class UserService {
	
//    @Autowired
//    protected UserRepository userRepository;
    
    @Autowired
    private UserMapper userMapper;

	/**
	 * 
	 */
	public UserService() {
		// TODO Auto-generated constructor stub
	}
	
    @Cacheable(value = "all-user-list", key = "'userlist'")
    public List<User> getAllUserList() {
    	return userMapper.selectAll();
//        return userRepository.list();
    }
}
