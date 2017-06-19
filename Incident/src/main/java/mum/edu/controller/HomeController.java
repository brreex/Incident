package mum.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String home(){
		return "hello";
	}
	
	@RequestMapping("/profile")
	public String profile(){
		return "profile";
	}
}
