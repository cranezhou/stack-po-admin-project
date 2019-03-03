/**
 * 
 */
package com.rillsoft.stackpoadmin.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.rillsoft.stackpoadmin.controller.ResourceController;
import com.rillsoft.stackpoadmin.domain.Resource;
import com.rillsoft.stackpoadmin.mapper.ResourceMapper;
import com.rillsoft.stackpoadmin.utils.PageInfo;

/**
 * @author crane
 *
 */
@Service
@CacheConfig(cacheNames = "resource")
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;
    
    private static final Logger LOG = LoggerFactory.getLogger(ResourceService.class);
    
	/**
	 * 
	 */
	public ResourceService() {
		// TODO Auto-generated constructor stub
	}

    @Cacheable(value = "all-resource-list", key = "'resourcelist'")
    public List<Resource> getAllResourceList() {
    	return resourceMapper.selectAll();
//        return resourceRepository.list();
    }
    
//    @Cacheable(value = "resource-list-by-page", key = "'resourcelistbypage'")
    public List<Resource> getResourceListByPage(PageInfo objPageInfo) {
    	
    	List<Resource> objResource = resourceMapper.selectAll();
    	
    	int nResourceTotal = objResource.size();
    	
    	int nPageIndex = objPageInfo.GetPageIndex();
    	int nPageSize = objPageInfo.GetPageSize();
    	
    	int nStartIndex = nPageIndex * nPageSize;
    	int nEndIndex = nStartIndex + nPageSize;
    	
    	if (nEndIndex > nResourceTotal) nEndIndex = nResourceTotal - 1;
    	
    	int nPageTotal = nResourceTotal / nPageSize;
    	
    	objPageInfo.SetPageTotal((nResourceTotal % nPageSize != 0) ? nPageTotal + 1 : nPageTotal);
    	
    	LOG.info("I am fine. nPageTotal=" + objPageInfo.GetPageTotal());
    	
    	List<Resource> objResourcePage = objResource.subList(nStartIndex, nEndIndex);

    	return objResourcePage;
//    	return objResource;
//    	return resourceMapper.selectResourceListByPage(objPageInfo);
    }
    
}
