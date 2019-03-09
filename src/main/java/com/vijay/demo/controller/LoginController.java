package com.vijay.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.vijay.demo.services.LoginServices;

@Controller
@SessionAttributes("vname")

public class LoginController {
	@Autowired
	LoginServices loginService;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getloginPage() {
		return "login";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String authenticateUser(@RequestParam("user")String username,@RequestParam("pwd")String password,ModelMap model) {
		if(!loginService.authUser(username, password)) {
			model.put("err_msg", "Invalid username or Password !<br> <p style=\"color: blue\">try again...<p>");
			return "login";
		}
		else {
			model.put("vname",username);
			return "redirect:/welcome";
		}
	}
	
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String getwelcomePage() {
		return "welcome";
	}
}
