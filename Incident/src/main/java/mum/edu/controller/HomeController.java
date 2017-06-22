package mum.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import mum.edu.service.IUserService;

@Controller
public class HomeController {
	@Autowired
	IUserService userService;
	
	@GetMapping({"/","/home"})
	public String home(){
		return "home";
	}
	
	@GetMapping("/login")
	public String login(){
		return "login";
	}
	
	@GetMapping("/403")
	public String unauthorized(){
		return "403";
	}
	
	@GetMapping("/navigation")
	public String navigationHeader(){
		return "navigation";
	}
}
