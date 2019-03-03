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

import com.rillsoft.stackpoadmin.service.UserService;

// import com.admin.application.UserService;
// import com.admin.interfaces.facade.assembler.UserAssembler;

/**
 * @author crane
 *
 */
@Controller
// @RequestMapping("/master/users")
public class UserController {

    @Autowired
    protected UserService userService;
    
	/**
	 * 
	 */
	
	public UserController() {
		// TODO Auto-generated constructor stub
		
	}
		
	/*
    @RequestMapping(value = "usersPage", method=RequestMethod.GET)
    public String usersPage(Model model){
    	
        // model.addAttribute("list", UserAssembler.domainToDto(userService.list()));
    	model.addAttribute("userlist", userService.getAllUserList());
    	
        return "master/users";
    }
    */
    
	//  @GetMapping("usersPage")
    @RequestMapping(value = "usersPage", method=RequestMethod.GET)
	public ModelAndView showUsers() {
	    
    	ModelAndView modelAndView = new ModelAndView("master/users");
	    
	    modelAndView.addObject("userlist", userService.getAllUserList());
	    
	    return modelAndView;
    }

/*
    @RequestMapping(value = "usersPage", method=RequestMethod.GET)
    public ModelAndView showUsers(){
    	
        // model.addAttribute("list", UserAssembler.domainToDto(userService.list()));
    	// model.addAttribute("userlist", userService.getAllUserList());
    	ModelAndView modelAndView = new ModelAndView("adminPage/role/roles");
    	
        return modelAndView;
    }
*/    
/*
    @GetMapping("/roles")
    public ModelAndView showRoles() {
        ModelAndView modelAndView = new ModelAndView("adminPage/role/roles");
        modelAndView.addObject("roles", roleService.findAll());
        return modelAndView;
	}
*/
}
