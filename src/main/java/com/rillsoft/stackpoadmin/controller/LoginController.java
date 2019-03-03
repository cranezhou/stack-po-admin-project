/**
 * 
 */
package com.rillsoft.stackpoadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author crane
 *
 */
@Controller
@RequestMapping("")
public class LoginController {

	/**
	 * 
	 */
	public LoginController() {
		// TODO Auto-generated constructor stub
	}

    // Login form with error
    @GetMapping("/login-error")		// entry defined in WebSecurityConfig.java 
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
}
}
