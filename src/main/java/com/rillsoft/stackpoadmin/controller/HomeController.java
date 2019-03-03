/**
 * 
 */
package com.rillsoft.stackpoadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author crane
 *
 */
@Controller
public class HomeController {

	/**
	 * 
	 */
	public HomeController() {
		// TODO Auto-generated constructor stub
	}

//    @RequestMapping(value = {"", "/", "hello"}, method=RequestMethod.GET)
    @RequestMapping(value = {"/", "/hello"}, method=RequestMethod.GET)
    public String hello(){
        return "hello";
    }
    
//    @RequestMapping(value = {"", "home"}, method=RequestMethod.GET)
//    public String index(){
//        return "home";
//    }
    
    @RequestMapping(value = {"/home"}, method=RequestMethod.GET)
    public String home(){
        return "home";
    }
    
    @RequestMapping(value = {"/homePage"}, method=RequestMethod.GET)
    public String homePage(){
        return "home";
    }

    @RequestMapping(value = "/login", method=RequestMethod.GET)
    public String login(){
        return "login";
    }

    @RequestMapping("/403")
    public String forbidden(){
        return "403";
    }
    
}
