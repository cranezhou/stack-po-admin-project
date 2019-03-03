/**
 * 
 */
package com.rillsoft.stackpoadmin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rillsoft.stackpoadmin.service.RoleService;

/**
 * @author crane
 *
 */
@Controller
public class RoleController {

    @Autowired
    protected RoleService roleService;
    
	/**
	 * 
	 */
	public RoleController() {
		// TODO Auto-generated constructor stub
	}

/*	
    @RequestMapping(value = "rolesPage", method=RequestMethod.GET)
    public String rolesPage(Model model){
    	
        // model.addAttribute("list", UserAssembler.domainToDto(userService.list()));
    	model.addAttribute("rolelist", roleService.getAllRoleList());
    	
        return "master/roles";
    }
*/

//    @GetMapping("rolesPage")
    @RequestMapping(value = "rolesPage", method=RequestMethod.GET)
    public ModelAndView showRoles() {
        ModelAndView modelAndView = new ModelAndView("master/roles");
        modelAndView.addObject("rolelist", roleService.getAllRoleList());
        return modelAndView;
	}
}
