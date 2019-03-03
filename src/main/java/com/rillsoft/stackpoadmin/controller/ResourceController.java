/**
 * 
 */
package com.rillsoft.stackpoadmin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rillsoft.stackpoadmin.StackPOAdminApplication;
import com.rillsoft.stackpoadmin.service.ResourceService;
import com.rillsoft.stackpoadmin.utils.PageInfo;
import com.rillsoft.stackpoadmin.domain.Resource;

/**
 * @author crane
 *
 */
@Controller
public class ResourceController {

    @Autowired
    protected ResourceService resourceService;
    
    private static final Logger LOG = LoggerFactory.getLogger(ResourceController.class);
    
	/**
	 * 
	 */
	public ResourceController() {
		// TODO Auto-generated constructor stub
	}

//    @RequestMapping(value = "resourcePage", method=RequestMethod.GET)
//    public String resourcePage(Model model){
//    	
//        // model.addAttribute("list", UserAssembler.domainToDto(userService.list()));
//    	// model.addAttribute("rolelist", roleService.getAllRoleList());
//    	
//        return "master/resource";
//    }
    
	//  @GetMapping("resourcePage")
    @RequestMapping(value = "resourcePage", method=RequestMethod.GET)
	public ModelAndView showResource() {
    	
    	// 1. get parameter from web ui page
    	// 2. create and setup objPageInfo object 
    	// 3. modelAndView.addObject("pageinfo", objPageInfo)
    	// 4. get resource by page
    	// 5. modelAndView.addObject("resourcelist", objResourceList) 
    	
    	// try to use pageImpl
    	
    	ModelAndView modelAndView = new ModelAndView("master/resource");
    	   	
//    	PageInfo pageInfo = new PageInfo();
    	
    	modelAndView.addObject("resourcelist", resourceService.getAllResourceList());
    	
    	modelAndView.addObject("nPrevPageIndex", 0);
    	modelAndView.addObject("nNextPageIndex", 1);
    	
    	modelAndView.addObject("nFirstPageIndex", 0); 
    	modelAndView.addObject("nLastPageIndex", 1);
    	
    	modelAndView.addObject("strCurrentPage", "1 / 1"); 
    
    	return modelAndView;
    }
    
	//  @GetMapping("showResourcebyPage")
    @RequestMapping(value = "showResourcebyPage", params="nPageIndex", method=RequestMethod.GET)
	public ModelAndView showResourcebyPage(@RequestParam(value="nPageIndex", required=false, defaultValue="0") int nPageIndex,
											@RequestParam(value="nPageSize", required=false, defaultValue="3") int nPageSize) {
    	
    	// 1. get parameter from web ui page
    	// 2. create and setup objPageInfo object 
    	// 3. modelAndView.addObject("pageinfo", objPageInfo)
    	// 4. get resource by page
    	// 5. modelAndView.addObject("resourcelist", objResourceList) 
    	
    	// try to use pageImpl
    	
    	ModelAndView modelAndView = new ModelAndView("master/resource");
    	
    	// 1. get parameter from web ui page
    	if (nPageIndex != 0)
    	{
    		LOG.info("I am fine. nPageIndex=" + nPageIndex);
    	}
    	if (nPageSize != 0)
    	{
    		LOG.info("I am fine. nPageSize=" + nPageSize);
    	}
    	
    	// 2. create and setup objPageInfo object
    	PageInfo objPageInfo = new PageInfo(nPageIndex, nPageSize);

    	// 3. setup page info object
//    	modelAndView.addObject("pageinfo", objPageInfo);
    	
    	// 4. get resource list (by page)
//    	List<Resource> objResourceList = resourceService.getAllResourceList();
    	
//    	modelAndView.addObject("resourcelist", objResourceList);

    	// 5.setup resource object
    	List<Resource> objResourceListByPage = resourceService.getResourceListByPage(objPageInfo);
    	
//    	LOG.info("I am fine. nPageTotal=" + objPageInfo.GetPageTotal());
    	
    	modelAndView.addObject("resourcelist", objResourceListByPage);

    	modelAndView.addObject("nPrevPageIndex", (nPageIndex > 1 ? nPageIndex - 1 : 0)); 		
    	modelAndView.addObject("nNextPageIndex", (nPageIndex + 1 < objPageInfo.GetPageTotal() ? nPageIndex + 1 : nPageIndex));
    
    	modelAndView.addObject("nFirstPageIndex", 0); 
    	modelAndView.addObject("nLastPageIndex", objPageInfo.GetPageTotal() - 1);
    	
    	String strCurrentPage = String.format("%d of %d", nPageIndex + 1, objPageInfo.GetPageTotal());
    	modelAndView.addObject("strCurrentPage", strCurrentPage); 
    	
    	return modelAndView;
    }
}

