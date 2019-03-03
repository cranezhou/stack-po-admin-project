/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rillsoft.stackpoadmin.domain.Role;
import com.rillsoft.stackpoadmin.mapper.RoleMapper;

/**
 * @author crane
 *
 */
@Service
// @CacheConfig(cacheNames = "role")
public class RoleService {

    @Autowired
    private RoleMapper roleMapper;
    
	/**
	 * 
	 */
	public RoleService() {
		// TODO Auto-generated constructor stub
	}

    // @Cacheable(value = "all-role-list", key = "'rolelist'")
    public List<Role> getAllRoleList() {
    	return roleMapper.selectAll();
//        return userRepository.list();
    }
}
